package rubllc.glyph.demo;

import android.content.ComponentName;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.nothing.ketchum.*;



public class MainActivity extends AppCompatActivity {
    private GlyphManager mGM = null;
    private GlyphManager.Callback mCallback = null;
    public void glyphie(View v){

        GlyphFrame.Builder builder = mGM.getGlyphFrameBuilder();
        GlyphFrame frame2 = builder.buildChannelB().buildPeriod(80000).build();
        mGM.toggle(frame2);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        mGM = GlyphManager.getInstance(getApplicationContext());
        mGM.init(mCallback);
        OnViewCreated();
    }

    private void init() {

        mCallback = new GlyphManager.Callback() {
            @Override
            public void onServiceConnected(ComponentName componentName) {
                if (Common.is20111()) mGM.register(Common.DEVICE_20111);
                if (Common.is22111()) mGM.register(Common.DEVICE_22111);
                if (Common.is23111()) mGM.register(Common.DEVICE_23111);
                try {
                    mGM.openSession();
                } catch(GlyphException e) {

                }
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                try{
                mGM.closeSession();}
                catch (Exception e){}
            }
        };
    }




    private void OnViewCreated() {
        Button channelABtn = (Button) findViewById(R.id.buttona);
        Button channelBBtn = (Button) findViewById(R.id.buttonb);
        Button channelCBtn = (Button) findViewById(R.id.buttonc);
        Button channelDBtn = (Button) findViewById(R.id.buttond);
        Button channelEBtn = (Button) findViewById(R.id.buttone);
        Button EmergencyBtn = (Button) findViewById(R.id.emg);

        final ImageView FrameA = findViewById(R.id.GlyphAFrame);
        final ImageView FrameB = findViewById(R.id.GlyphBFrame);
        final ImageView FrameC = findViewById(R.id.GlyphCFrame);
        final ImageView FrameD = findViewById(R.id.GlyphDFrame);
        final ImageView FrameE = findViewById(R.id.GlyphEFrame);


        channelABtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Button pressed, change the image and start the animation
                        GlyphFrame.Builder builder = mGM.getGlyphFrameBuilder();
                        FrameA.setImageResource(R.drawable.a1);
                        GlyphFrame frame = builder.buildChannelA().buildPeriod(3000).build();
                        mGM.animate(frame);
                        return true; // return true to indicate that the event is consumed

                    case MotionEvent.ACTION_UP:
                        // Button released, revert the image and stop the animation
                        FrameA.setImageResource(R.drawable.a0);
                        mGM.turnOff();
                        return true; // return true to indicate that the event is consumed
                }
                return false; // return false to indicate that the event is not consumed
            }
        });

        channelBBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Button pressed, change the image and start the animation
                        GlyphFrame.Builder builder = mGM.getGlyphFrameBuilder();
                        FrameB.setImageResource(R.drawable.b1);
                        GlyphFrame frame = builder.buildChannelB().buildPeriod(3000).build();
                        mGM.animate(frame);
                        return true; // return true to indicate that the event is consumed

                    case MotionEvent.ACTION_UP:
                        // Button released, revert the image and stop the animation
                        FrameB.setImageResource(R.drawable.b0);
                        mGM.turnOff();
                        return true; // return true to indicate that the event is consumed
                }
                return false; // return false to indicate that the event is not consumed
            }
        });

        channelCBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Button pressed, change the image and start the animation
                        GlyphFrame.Builder builder = mGM.getGlyphFrameBuilder();
                        FrameC.setImageResource(R.drawable.c1);
                        GlyphFrame frame = builder.buildChannelC().buildPeriod(3000).build();
                        mGM.animate(frame);
                        return true; // return true to indicate that the event is consumed

                    case MotionEvent.ACTION_UP:
                        // Button released, revert the image and stop the animation
                        FrameC.setImageResource(R.drawable.c0);
                        mGM.turnOff();
                        return true; // return true to indicate that the event is consumed
                }
                return false; // return false to indicate that the event is not consumed
            }
        });

        channelDBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Button pressed, change the image and start the animation
                        GlyphFrame.Builder builder = mGM.getGlyphFrameBuilder();
                        FrameD.setImageResource(R.drawable.d1);
                        GlyphFrame frame = builder.buildChannelD().buildPeriod(3000).build();
                        mGM.animate(frame);
                        return true; // return true to indicate that the event is consumed

                    case MotionEvent.ACTION_UP:
                        // Button released, revert the image and stop the animation
                        FrameD.setImageResource(R.drawable.d0);
                        mGM.turnOff();
                        return true; // return true to indicate that the event is consumed
                }
                return false; // return false to indicate that the event is not consumed
            }
        });

        channelEBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Button pressed, change the image and start the animation
                        GlyphFrame.Builder builder = mGM.getGlyphFrameBuilder();
                        FrameE.setImageResource(R.drawable.e1);
                        GlyphFrame frame = builder.buildChannelE().buildPeriod(3000).build();
                        mGM.animate(frame);
                        return true; // return true to indicate that the event is consumed

                    case MotionEvent.ACTION_UP:
                        // Button released, revert the image and stop the animation
                        FrameE.setImageResource(R.drawable.e0);
                        mGM.turnOff();
                        return true; // return true to indicate that the event is consumed
                }
                return false; // return false to indicate that the event is not consumed
            }
        });


    }
}