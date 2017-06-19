package sales.pg;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Expenses extends Activity implements View.OnClickListener{
EditText datepicker;
    ImageView back;
    private int mYear, mMonth, mDay, mHour, mMinute;
    Button submit_expenses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.expenses);
        back = (ImageView)findViewById(R.id.back);
        datepicker = (EditText)findViewById(R.id.datepicker);
        submit_expenses = (Button)findViewById(R.id.submit_expenses);
        submit_expenses.setOnClickListener(this);
        datepicker.setOnClickListener(this);

        back.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.submit_expenses:
                if (datepicker.getText().toString().length()>0){
                    final AlertDialog.Builder aler = new AlertDialog.Builder(Expenses.this);
                    aler.setTitle("NGFCPL");
                    aler.setIcon(getResources().getDrawable(R.drawable.appicon));
                    aler.setMessage("Sucessfully Created Record  ");
                    aler.show();
                }else {
                    final AlertDialog.Builder aler = new AlertDialog.Builder(Expenses.this);
                    aler.setTitle("NGFCPL");
                    aler.setIcon(getResources().getDrawable(R.drawable.appicon));
                    aler.setMessage("Please Fill Atleast One Entity  ");
                    aler.show();
                }
                break;
            case R.id.back:
                finish();
                break;
            case R.id.datepicker:
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialogn = new DatePickerDialog(this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                Calendar calendar = Calendar.getInstance();
                                SimpleDateFormat mdformat = new SimpleDateFormat("HH:mm:ss a");
                                String strDate =  mdformat.format(calendar.getTime());
                                datepicker.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year +" :"+strDate);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialogn.show();

                break;
        }
    }
}
