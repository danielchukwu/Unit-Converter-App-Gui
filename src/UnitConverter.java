import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

public class UnitConverter {

    void home() {

        // Create and set defaults
        JFrame frame = new JFrame("Inches to Meter and Meters to Inches");
        frame.setSize(500, 300);

        // Options
        String [] options = {"meter to inches", "inches to meter"};

        for (int i = 0; i < options.length; i++) {
            JButton button = new JButton(options[i]);    // create button
            frame.add(button);  // Add button to frame

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(button.getText());
                    if (button.getText().equals("meter to inches")){
                        meterToInchesInput();
                    } else if (button.getText().equals("inches to meter")) {
                        inchesToMetersInput();
                    }
                    frame.setVisible(false);
                }
            });
        }
        frame.setLayout(new GridLayout(1, 2));
        frame.setVisible(true);
    }

    void meterToInchesInput() {
        // Create and set defaults
        JFrame frame = new JFrame("Meter to Inches");
        frame.setSize(500, 300);

        // Input
        JTextField meters = new JTextField();
        frame.add(meters);


        // Submit Button
        JButton button = new JButton("=");
        frame.add(button);
        // Button: Action Listener
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String metersText = meters.getText();
                int metersNumber = Integer.parseInt(metersText);  // Convert String input to Integer

                double resultInInches = 39.3701  * metersNumber;  // convert

                // Print to Console
                System.out.println("meters: "+metersText);
                System.out.println("Result in Inches: "+resultInInches);

                // Call Method "writeUnitConversion" to -> create file and right result to file
                writeUnitConversion("Inches to Meters Conversion-------------\nInches: "+metersText+"\nResult in Meters: "+resultInInches);
            }
        });

        // Go back Button
        JButton goBackButton = new JButton("Go Back");
        frame.add(goBackButton);
        // Add Action Listener on Go Back
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                home();
            }
        });
        frame.setLayout(new GridLayout(2, 2));
        frame.setVisible(true);

    }

    void inchesToMetersInput() {
        // Create and set defaults
        JFrame frame = new JFrame("Inches to Meter");
        frame.setSize(500, 300);

        // Input
        JTextField inches = new JTextField();
        frame.add(inches);


        // Submit Button
        JButton button = new JButton("=");
        frame.add(button);
        // Button ActionListener
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inchesText = inches.getText();
                int inchesNumber = Integer.parseInt(inchesText); // Convert String input to Integer

                double resultInMeters = 0.0254 * inchesNumber; // convert

                // Print to Console
                System.out.println("Inches: "+inchesText);
                System.out.println("Result in meters: "+resultInMeters);

                // Call Method "writeUnitConversion" to -> create file and right result to file
                writeUnitConversion("Inches to Meters Conversion-------------\nInches: "+inchesText+"\nResult in Meters: "+resultInMeters);
            }
        });


        // Go back Button
        JButton goBackButton = new JButton("Go Back");
        frame.add(goBackButton);
        // goBackButton ActionListener
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                home();
            }
        });

        frame.setLayout(new GridLayout(2, 2));
        frame.setVisible(true);


    }


    // Write To File Method
    void writeUnitConversion(String message){
        try {
            FileWriter file = new FileWriter("unitConverterFile.txt");
            file.write(message);
            file.close();
        } catch (Exception e) {
            System.out.println("File Exception: " + e);
        }
    }

}
