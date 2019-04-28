package domain;

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

         public Textbook build()
         {
             return new Textbook(this);
         }



    }

}
