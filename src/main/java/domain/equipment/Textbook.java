package domain.equipment;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class Textbook {

    private String textbookName;
    private String textbookCode;

    private Textbook() {
    }

    private Textbook (Builder builder)
    {
        this.textbookCode = builder.textbookCode;
        this.textbookName = builder.textbookName;
    }

    public String getTextbookCode() {
        return textbookCode;
    }

    public String getTextbookName() {
        return textbookName;
    }

    public static class Builder{

        private String textbookCode, textbookName;

         public Builder textbookCode(String textbookCode)
         {
             this.textbookCode = textbookCode;
             return this;
         }

         public Builder textbookName(String textbookName)
         {
             this.textbookName = textbookName;
             return this;
         }

        public Builder copy(Textbook textbook){
            this.textbookCode = textbook.textbookCode;
            this.textbookName = textbook.textbookName;

            return this;
        }

         public Textbook build()
         {
             return new Textbook(this);
         }

    }
    @Override
    public String toString() {
        return "Textbook {" +
                "textbookCode" + textbookCode + '\'' +
                "textbookName" + textbookName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Textbook textbook = (Textbook) o;
        return textbookCode.equals(textbook.textbookCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(textbookCode);
    }
}
