package my.com.taruc.lab12bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextWeight, editTextHeight;
    private TextView textViewResult;
    private ImageView imageViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Linking UI to program
        editTextHeight = (EditText)findViewById(R.id.editTextHeight);
        editTextWeight = (EditText)findViewById(R.id.editTextWeight);
        textViewResult = (TextView)findViewById(R.id.textViewResult);
        imageViewResult =(ImageView)findViewById(R.id.imageViewResult);


    }

    public void calculateBMI(View view)
    {
        //TODO : calculate and display result
        double weight,height,bmi;

        weight = Double.parseDouble(editTextWeight.getText().toString());
        height = Double.parseDouble(editTextHeight.getText().toString());
        height = height/100;
        bmi = weight/(Math.pow(height,2));
        bmi= Math.round(bmi*100)/100;

        if(bmi <= 18.5)
        {
            textViewResult.setText("BMI : " + bmi + "You are under weight!");
            imageViewResult.setImageResource(R.drawable.under);
        }
        else if(bmi >=21)
        {
            textViewResult.setText("BMI : " + bmi + "You are OVER weight!");
            imageViewResult.setImageResource(R.drawable.over);
        }
        else
        {
            textViewResult.setText("BMI : " + bmi + "Don't worry you are Normal!");
            imageViewResult.setImageResource(R.drawable.normal);
        }

    }

    public void resetBMI(View view)
    {
        editTextHeight.setText("");
        editTextWeight.setText("");
        textViewResult.setText(getString(R.string.bmi));
        imageViewResult.setImageResource(R.drawable.empty);
    }
}
