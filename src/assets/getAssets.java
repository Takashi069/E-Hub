package assets;

import gui.secret;

public class getAssets {
    secret path = new secret();
    private String prefix = path.prefix;

    public String frame_bg = prefix + "frame_bg2.png";
    public String req_bg = prefix  + "req_proj.png";
    public String view_bg = prefix + "view_proj.png";

    public String request_btn = prefix + "req_button.png";
    public String disabled_request_btn = prefix + "disabled_req_button.png";
    public String reset_btn = prefix + "reset_button.png";
    public String back_btn = prefix + "back_button.png";
    public String suggest_btn = prefix + "suggest_button.png";
    
}
