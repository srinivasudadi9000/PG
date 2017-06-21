package sales.pg;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Orders extends Activity implements View.OnClickListener{
    EditText orderdate,delear_name,place,productgroup,brandname,uom,size,quantity,delivery_date,paymentcredit,remarks;
    ImageView back;
    TextView ordernumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.orders);
        back = (ImageView)findViewById(R.id.back);
        ordernumber = (TextView)findViewById(R.id.ordernumber);
        orderdate = (EditText)findViewById(R.id.orderdate);
        delear_name = (EditText)findViewById(R.id.delear_name);
        place = (EditText)findViewById(R.id.place);
        productgroup = (EditText)findViewById(R.id.productgroup);
        brandname = (EditText)findViewById(R.id.brandname);
        uom = (EditText)findViewById(R.id.uom);
        size = (EditText)findViewById(R.id.size);
        quantity = (EditText)findViewById(R.id.quantity);
        delivery_date = (EditText)findViewById(R.id.delivery_date);
        paymentcredit = (EditText)findViewById(R.id.paymentcredit);
        remarks = (EditText)findViewById(R.id.remarks);
        delivery_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat mdformat = new SimpleDateFormat("dd/ MM / yyyy  ");
                String strDate =  mdformat.format(calendar.getTime());
                delivery_date.setText(strDate);
            }
        });
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                finish();
                break;
        }
    }
}
