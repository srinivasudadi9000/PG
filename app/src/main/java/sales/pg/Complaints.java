package sales.pg;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Complaints extends Activity implements View.OnClickListener{
EditText delivery_date;
    ImageView back;
    RelativeLayout mycomplaint_rl;

    private AnimatorSet mSetRightOut;
    private AnimatorSet mSetLeftIn;
    private boolean mIsBackVisible = false;
    private View mCardFrontLayout;
    private View mCardBackLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.complaints);
        mycomplaint_rl = (RelativeLayout)findViewById(R.id.mycomplaint_rl);
       /* Animation slideUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomin);
       // Animation slideDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
        mycomplaint_rl.startAnimation(slideUp);*/


        loadAnimations();
        //  mSetRightOut.setTarget(mycomplaint_rl);
        mSetLeftIn.setTarget(mycomplaint_rl);
        //  mSetRightOut.start();
        mSetLeftIn.start();

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

    private void changeCameraDistance() {
        int distance = 8000;
        float scale = getResources().getDisplayMetrics().density * distance;
        mCardFrontLayout.setCameraDistance(scale);
        mCardBackLayout.setCameraDistance(scale);
    }

    private void loadAnimations() {
        mSetRightOut = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.out_animation);
        mSetLeftIn = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.in_animation);
    }


}
