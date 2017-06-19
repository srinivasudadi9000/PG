package sales.pg;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Receipt extends Activity implements View.OnClickListener{
EditText delivery_date;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.receipt);
        back = (ImageView)findViewById(R.id.back);
        delivery_date = (EditText)findViewById(R.id.delivery_date);
        delivery_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* Calendar cal = new GregorianCalendar();
                cal.setTime(new Date());
                cal.add(Calendar.MONTH, 2);
                long time = cal.getTime().getTime();
                Uri.Builder builder = CalendarContract.CONTENT_URI.buildUpon();
                builder.appendPath("time");
                builder.appendPath(Long.toString(time));
                Intent intent =  new Intent(Intent.ACTION_VIEW, builder.build());
                startActivity(intent);
*/
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
