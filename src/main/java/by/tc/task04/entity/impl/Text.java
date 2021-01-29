package by.tc.task04.entity.impl;

import java.io.Serializable;

public class Text implements Serializable {
    private String textContent;

    public Text() {
    }

    public Text(String textContent) {
        this.textContent = textContent;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    @Override
    public int hashCode() {
        int hash = (this.textContent == null) ? 0 : this.textContent.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Text other = (Text) obj;
        if (this.textContent == null) {
            return other.textContent == null;
        } else if (!this.textContent.equals(other.textContent)) {
            return false;
        }
        return true;
    }
}
