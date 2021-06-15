package sample.Controllers;

public class ButtonString {
    private String button;
    private static ButtonString buttonString;

    public static ButtonString getInstance(){
        if(buttonString == null){
            buttonString = new ButtonString();
        }
        return buttonString;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }
}
