package dev.meanmail.codeInsight.inspections

import com.intellij.codeInspection.InspectionManager
import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemDescriptor
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.psi.PsiFile
import com.intellij.psi.util.PsiTreeUtil
import dev.meanmail.NginxFileType
import dev.meanmail.codeInsight.completion.directives.geo
import dev.meanmail.codeInsight.completion.directives.http
import dev.meanmail.codeInsight.completion.directives.stream
import dev.meanmail.psi.DirectiveStmt

class NginxGeoInspection : LocalInspectionTool() {
    override fun checkFile(
        file: PsiFile,
        manager: InspectionManager,
        isOnTheFly: Boolean
    ): Array<ProblemDescriptor> {
        if (file.fileType != NginxFileType) return emptyArray()

        val problems = mutableListOf<ProblemDescriptor>()
        val directivesStmts = PsiTreeUtil.findChildrenOfType(file, DirectiveStmt::class.java)

        for (directiveStmt in directivesStmts) {
            if (directiveStmt.name != geo.name) continue

            val path = directiveStmt.path
            val isInHttpContext = path.any { it == http.name }
            val isInStreamContext = path.any { it == stream.name }

            if (!isInHttpContext && !isInStreamContext) {
                // Ignore if it's not in http or stream context
                continue
            }

            // Check parameters inside the block depending on the context
            val geoDirective = directiveStmt.geoDirectiveStmt ?: continue
            val blockStmt = geoDirective.geoBlockStmt ?: continue

            if (!isInHttpContext) {
                val proxy = blockStmt.geoBlockContentList.find { it.geoProxyStmt != null }
                if (proxy != null) {
                    problems.add(
                        manager.createProblemDescriptor(
                            proxy.geoProxyStmt!!,
                            "The 'proxy' parameter is only allowed in http context",
                            true,
                            ProblemHighlightType.ERROR,
                            isOnTheFly
                        )
                    )
                }

                val delete = blockStmt.geoBlockContentList.find { it.geoDeleteStmt != null }
                if (delete != null) {
                    problems.add(
                        manager.createProblemDescriptor(
                            delete.geoDeleteStmt!!,
                            "The 'delete' parameter is only allowed in http context",
                            true,
                            ProblemHighlightType.ERROR,
                            isOnTheFly
                        )
                    )
                }

                val ranges = blockStmt.geoBlockContentList.find { it.geoRangesStmt != null }
                if (ranges != null) {
                    problems.add(
                        manager.createProblemDescriptor(
                            ranges.geoRangesStmt!!,
                            "The 'ranges' parameter is only allowed in http context",
                            true,
                            ProblemHighlightType.ERROR,
                            isOnTheFly
                        )
                    )
                }
            }

            val default = blockStmt.geoBlockContentList.find { it.geoDefaultStmt != null }
            if (default == null) {
                problems.add(
                    manager.createProblemDescriptor(
                        geoDirective,
                        "The 'default' parameter is required in geo block",
                        true,
                        ProblemHighlightType.ERROR,
                        isOnTheFly
                    )
                )
            }
        }

        return problems.toTypedArray()
    }
}
