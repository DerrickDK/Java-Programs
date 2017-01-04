//This program uses for loops and static methods to output a scalable hour glass figure
  

public class HourGlass {
    public static final int HEIGHT = 9; // scalable constant

    public static void main(String[] args) {
        Quotes();
        TopTriangle();
        DoubleLine();
        BottomTriangle();
        Quotes();

    }
    // This method outputs the quotation marks incased in the pipe symbol.
    public static void Quotes() {
        System.out.print("|");
        for (int i = 1; i <= 2*HEIGHT+2; i++) {
            System.out.print("\"");

        }
        System.out.print("|");
        System.out.println();
    }
    // This method outputs the top of the triangular shape of the hour glass.
    public static void TopTriangle() {
        for (int i = 0; i < HEIGHT; i++) {

            for (int j = 0; j <= i ; j++) {
                System.out.print(" ");
            }
            System.out.print("\\");

            for (int j = 1; j <= 2*HEIGHT- (2*i); j++) {
                System.out.print(":");
            }
            System.out.print("/");
            System.out.println(); 
        }
    }
    // This method outputs the bottom of the triangular shape of the hour glass.
    public static void BottomTriangle() {
        for (int i = HEIGHT; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            System.out.print("/");

            for (int j = 0; j <= (2*HEIGHT - 2*i) + 1; j++) {
                System.out.print(":");
            }

            System.out.print("\\");
            System.out.println();
        }

    }
    //This method outputs the double line that is in the center of the hour glass.
    public static void DoubleLine() {
        for(int i=0; i<=HEIGHT; i++){
            System.out.print(" ");
        }
        System.out.println("||");
    }
}
