// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import dev.meanmail.psi.impl.*;

public interface Types {

    IElementType BLOCK_STMT = new NginxElementType("BLOCK_STMT");
    IElementType DIRECTIVE_STMT = new NginxElementType("DIRECTIVE_STMT");
    IElementType NAME_STMT = new NginxElementType("NAME_STMT");
    IElementType VALUES_STMT = new NginxElementType("VALUES_STMT");
    IElementType VALUE_STMT = new NginxElementType("VALUE_STMT");

    IElementType COMMENT = new NginxTokenType("COMMENT");
    IElementType EOL = new NginxTokenType("EOL");
    IElementType IDENTIFIER = new NginxTokenType("IDENTIFIER");
    IElementType LBRACE = new NginxTokenType("LBRACE");
    IElementType RBRACE = new NginxTokenType("RBRACE");
    IElementType SEMICOLON = new NginxTokenType("SEMICOLON");
    IElementType VALUE = new NginxTokenType("VALUE");
    IElementType WHITE_SPACE = new NginxTokenType("WHITE_SPACE");

    class Factory {
        public static PsiElement createElement(ASTNode node) {
            IElementType type = node.getElementType();
            if (type == BLOCK_STMT) {
                return new BlockStmtImpl(node);
            } else if (type == DIRECTIVE_STMT) {
                return new DirectiveStmtImpl(node);
            } else if (type == NAME_STMT) {
                return new NameStmtImpl(node);
            } else if (type == VALUES_STMT) {
                return new ValuesStmtImpl(node);
            } else if (type == VALUE_STMT) {
                return new ValueStmtImpl(node);
            }
            throw new AssertionError("Unknown element type: " + type);
        }
    }
}
