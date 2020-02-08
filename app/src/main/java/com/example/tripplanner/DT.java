/*
 * CLASS   : DT
 * PURPOSE : This is the object that's used to hold Destinations/Transits
 *           that are created in the StartTripActivity. Destinations are
 *           places that the user is staying on their Trip and Transit
 *           are methods of transportation.
 */

package com.example.tripplanner;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

// Data members:
//  - type (whether it's a Destination or Transit) [enum]
//  - name (the name that the user gives the Destination/Trip)[string]
//      Destination example: Hotel, Motel, etc.
//      Transit: Car, Bus, or Train
public class DT extends AppCompatActivity {
    // This enum is used to determine whether the DT object
    // is a Destination or Transit.
    public enum DT_Type {
        DESTINATION,
        TRANSIT
    }

    private DT_Type type; // Whether the trip is a Destination or Transit (or not selected)
    private String name; // The name given to the Destination or Transit
    private EditText nameBox;
    private Spinner typeSpinner;

    /*
        FUNCTION: DT
        DESCRIPTION: Constructor for the DT class. Allows specify a name (e.g. Motel/Hotel,
                     or Car/Bus).
        PARAMETERS:
            String _name: The name of the Destination or Transit.
        RETURNS: N/A
    */
    public DT (String _name) {
        this.type = DT_Type.DESTINATION;
        this.name = _name;
    }

    /*
        FUNCTION: DT
        DESCRIPTION: Accessor for 'private String name'. Allows retrieving
                     the value of the data member.
        PARAMETERS: N/A
        RETURNS: String: The value of the 'String name'.
    */
    public String getName() {
        return this.name;
    }

    /*
        FUNCTION: DT
        DESCRIPTION: Accessor for 'private DT_Type type'. Allows retrieving
                     the value of the data member.
        PARAMETERS: N/A
        RETURNS: DT_Type: The value of the 'String name'.
    */
    public DT_Type getDT_Type() {
        return this.type;
    }

    /*
        FUNCTION: CreateDestinationTransit()
        DESCRIPTION: Creates a all elements needed to add a new Destination/Transit.
                     Elements that are created include: DT object, EditText, and Spinner.
        PARAMETERS:
            AppCompatActivity activity: The Activity that the UI elements are being displayed on
            LinearLayout mainLayout: The LinearLayout that contains the LinearLayout created
                                     in this method.
            String name: The name that's being assigned to the DT object
            DT_Type newType: The type of DT object that's being created (either Destination or Transit)
        RETURNS:
            DT: The Dt object that was created
    */
    public static DT CreateDestinationTransit(AppCompatActivity activity, LinearLayout mainLayout, String name, DT_Type newtype) {
        // Create the DT object
        final DT newDT = new DT(name); // Object needs to be 'final' to be accessed within the listeners

        // Create the new layout and add it to the main layout
        LinearLayout subLayout = UIManager.createLinearLayout(activity);
        mainLayout.addView(subLayout);

        // Create the EditText and add it to the sub-layout
        newDT.nameBox = UIManager.createEditText(activity);
        subLayout.addView(newDT.nameBox);
        newDT.nameBox.setText(name);

        // Create the Spinner and add it to the sub-layout
        newDT.typeSpinner = UIManager.createSpinner(activity);
        subLayout.addView(newDT.typeSpinner);
        switch(newtype){
            case DESTINATION:
                newDT.typeSpinner.setSelection(0);
                break;
            case TRANSIT:
                newDT.typeSpinner.setSelection(1);
                break;
        }

        // Add a listener for the EditText
        newDT.nameBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence text, int start, int before, int count) {
                // Update the name of the DT object
                newDT.name = text.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // Add a listener for the Spinner
        newDT.typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();

                // Assign to the DT_Type enum based on the selected item
                if (selectedItem.equals("Destination")) {
                    newDT.type = DT_Type.DESTINATION;
                }
                else if (selectedItem.equals("Transit")) {
                    newDT.type = DT_Type.TRANSIT;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return newDT;
    }
}
