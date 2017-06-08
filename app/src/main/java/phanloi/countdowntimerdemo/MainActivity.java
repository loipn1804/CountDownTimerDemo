package phanloi.countdowntimerdemo;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txtLog)
    TextView txtLog;

    @OnClick(R.id.btnStart)
    void start() {
        mCountDownTimer.cancel();
        mCountDownTimer.start();
    }

    @OnClick(R.id.btnStop)
    void stop() {
        mCountDownTimer.cancel();
    }

    private CountDownTimer mCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mCountDownTimer = new CountDownTimer(10000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                txtLog.setText("" + millisUntilFinished);
            }

            @Override
            public void onFinish() {
                txtLog.setText("Finish");
            }
        };
    }
}
