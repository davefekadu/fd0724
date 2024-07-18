package main.java.com.demo.toolrental;

public class ToolFactory {
    // Factory method to create tool instances based on tool code and brand
    public static Tool createTool(String toolCode, String brand) {
        switch (toolCode) {
            case "LADW":
                return new Ladder(toolCode, brand);
            case "CHNS":
                return new Chainsaw(toolCode, brand);
            case "JAKD":
            case "JAKR":
                return new Jackhammer(toolCode, brand);
            default:
                throw new IllegalArgumentException("Invalid tool code");
        }
    }
}
