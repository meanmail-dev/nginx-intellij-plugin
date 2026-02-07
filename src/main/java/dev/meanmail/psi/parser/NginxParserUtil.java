package dev.meanmail.psi.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.parser.GeneratedParserUtilBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;

/**
 * Parser utilities for Nginx grammar.
 * <p>
 * The method {@link #adjacentToNext} is used as a syntactic predicate to ensure
 * concatenation happens only when the next token is immediately adjacent (i.e.,
 * there is no whitespace or comment token between parts).
 */
public class NginxParserUtil extends GeneratedParserUtilBase {

    /**
     * Returns true if the next token is a significant token and not a separator
     * (no whitespace/comment between concatenation pieces).
     * <p>
     * Note: In Grammar-Kit predicates like &<<adjacentToNext>> are executed right before
     * the next piece is parsed. If there is whitespace/comment between pieces, builder
     * will expose that separator as the current token, and this method must return false.
     */
    public static boolean adjacentToNext(PsiBuilder b, int level) {
        // Robust adjacency check:
        // true iff there are NO whitespace/comment raw tokens between the previous significant token and current token.
        try {
            com.intellij.lang.impl.PsiBuilderImpl bi = (com.intellij.lang.impl.PsiBuilderImpl) b;
            int idx = bi.rawTokenIndex();
            if (idx < 0) return false;

            // In &<<adjacentToNext>> context, current rawTokenIndex() points to the NEXT token.
            // We consider it adjacent if the immediate previous raw token is not WS/COMMENT.
            int prev = idx - 1;
            IElementType prevType = bi.rawLookup(prev);
            boolean adjacent = prev >= 0 && prevType != TokenType.WHITE_SPACE && !isCommentToken(prevType);

            if (Boolean.parseBoolean(System.getProperty("nginx.debug.adj", "false"))) {
                IElementType curType = bi.rawLookup(idx);
                String msg = "[DEBUG_LOG] adjacentToNext: prevIdx=" + prev + ", prevType=" + prevType
                        + ", curIdx=" + idx + ", curType=" + curType + ", adjacent=" + adjacent;
                System.err.println(msg);
                System.out.println(msg);
            }

            return adjacent;
        } catch (Throwable t) {
            return false;
        }
    }

    private static boolean isCommentToken(IElementType t) {
        // We cannot import plugin token for COMMENT here safely; compare by debug name
        return t != null && "COMMENT".equals(String.valueOf(t));
    }
}
