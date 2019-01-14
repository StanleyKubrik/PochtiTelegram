package view;

public interface Route{
    <T extends IPanel> void addView(T panel);
    <T extends IPanel> void remove(T panel);
    void viewLogin();
    void viewChat();
    void setVisible(boolean flag);
    void dispose();
}
