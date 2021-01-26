package by.tc.task04.entity.impl;

import by.tc.task04.entity.TextPart;

import java.io.Serializable;

public class CodeBlock implements TextPart, Serializable {
    private String codeBlockContent;
    public CodeBlock(){
        codeBlockContent="";
    }
    public CodeBlock(String codeBlockContent){
        this.codeBlockContent=codeBlockContent;
    }

    public String getCodeBlockContent() {
        return codeBlockContent;
    }

    public void setCodeBlockContent(String codeBlockContent) {
        this.codeBlockContent = codeBlockContent;
    }

    @Override
    public String getContent() {
        return codeBlockContent;
    }

    @Override
    public int hashCode() {
        return (codeBlockContent == null) ? 0 : codeBlockContent.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        CodeBlock w = (CodeBlock) obj;
        if (null == this.codeBlockContent) {
            return null == w.codeBlockContent;
        } else if (!this.codeBlockContent.equals(w.codeBlockContent)) {
            return false;
        }
        return true;
    }
}
