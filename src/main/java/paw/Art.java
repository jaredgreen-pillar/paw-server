package paw;

public class Art {

    private String text;

    public Art(String text) {
        this.text = text;
    }

    public Art() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (!Art.class.isAssignableFrom(object.getClass())) {
            return false;
        }

        final Art other = (Art) object;
        if ((this.text == null) ? (other.text != null) : !this.text.equals(other.text)) {
            return false;
        }

        return true;
    }
}
