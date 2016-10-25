package com.muran.mrshop.utils;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.Animation;

import com.muran.mrshop.R;

/**
 * Created by Administrator on 2016/8/30.
 */
public class ShakeUtil implements SensorEventListener {
    // 定义sensor管理器
    private SensorManager mSensorManager;
    // 震动
    private Vibrator vibrator;
    // 声音
    private SoundPool pool;
// 动画
    /**
     * animation五个子类传入：AlphaAnimation。TranslateAnimation。ScaleAnimation。
     * RotateAnimation。 AnimationSet
     */
    private Animation animation;
    private AnimationDrawable aDrawable;
    private Context context;
    private static ShakeUtil shakeUtil;
    public static int DEFAULTRES = -1;
    private boolean isVibrator;
    private boolean isSound;
    private boolean isAnimation;
    private boolean isAnimationDrawable;
    private int sourceid;
    private View view;
    private ShakeListener listener;
    private boolean isShaking=false;
    int medumValue = 15;// 三星 i9250怎么晃都不会超过20，没办法，只设置19了

    public static ShakeUtil getIntasnce(Context context) {
        if (null == shakeUtil) {
            shakeUtil = new ShakeUtil(context, new ShakeListener() {
                @Override
                public void Handler() {

                }
            });
        }

        return shakeUtil;
    }

    public ShakeUtil(Context context, ShakeListener shakeListener) {
        this.context = context;
        listener = shakeListener;
        initManager();
    }

    public void HandlerPost() {
        listener.Handler();
    }


    /**
     * 获取传感器服务
     */
    private void initManager() {
        mSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
    }

    /**
     * 设置震动
     *
     * @param isVibrator
     * @return
     */
    public ShakeUtil setVibrator(boolean isVibrator) {
        this.isVibrator = isVibrator;
        if (isVibrator) {
            vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        }
        return this;
    }

    /**
     * 设置声音
     *
     * @param isSound
     * @param soundRes
     * @return
     */
    @SuppressWarnings("deprecation")
    public ShakeUtil setSound(boolean isSound, int soundRes) {
        this.isSound = isSound;
        if (isSound) {
// 指定声音池的最大音频流数目为10，声音品质为5
            pool = new SoundPool(10, AudioManager.STREAM_SYSTEM, 5);
            if (DEFAULTRES == soundRes) {
                soundRes = R.raw.shake;
            }
// 载入音频流，返回在池中的id
            sourceid = pool.load(context, soundRes, 0);
        }
        return this;
    }

    /**
     * 添加动画（tweenAnimation）
     *
     * @param isAnimation
     * @param animation
     * @return
     */
    public ShakeUtil setAnimation(boolean isAnimation, Animation animation, View view) {
        this.isAnimation = isAnimation;
        if (isAnimation) {
            if (null != animation)
                this.animation = animation;
            if (null != view)
                this.view = view;
        }
        return this;
    }

    /**
     * 添加动画（frameAnimation）
     *
     * @param isAnimationDrawable
     * @param aDrawable
     * @return
     */
    public ShakeUtil setAnimationDrawable(boolean isAnimationDrawable, AnimationDrawable aDrawable) {
        this.isAnimationDrawable = isAnimationDrawable;
        if (isAnimationDrawable) {
            if (null != aDrawable)
                this.aDrawable = aDrawable;
        }
        return this;
    }

    /**
     * 注册加速度传感器
     */
    public void register() {
        if (null != mSensorManager)
            mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                // 还有SENSOR_DELAY_UI、SENSOR_DELAY_FASTEST、SENSOR_DELAY_GAME等，
                // 根据不同应用，需要的反应速率不同，具体根据实际情况设定
                    SensorManager.SENSOR_DELAY_NORMAL);
    }

    /**
     * 注销传感器
     */
    public void unregister() {
        if (null != mSensorManager)
            mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        int sensorType = event.sensor.getType();
        // values[0]:X轴，values[1]：Y轴，values[2]：Z轴
        float[] values = event.values;
        if (sensorType == Sensor.TYPE_ACCELEROMETER) {
            /*
             * 因为一般正常情况下，任意轴数值最大就在9.8~10之间，只有在你突然摇动手机
             *
             * 的时候，瞬时加速度才会突然增大或减少。
             *
             * 所以，经过实际测试，只需监听任一轴的加速度大于14的时候，改变你需要的设置
             *
             * 就OK了~~~（也有说打速度大于14时回掉）
             *
             */

            if ((Math.abs(values[0]) > medumValue || Math.abs(values[1]) > medumValue || Math.abs(values[2]) > medumValue)) {
                if (!isShaking){
                    isShaking=!isShaking;
                    if (isVibrator)
                        // 摇动手机后，再伴随震动提示~~
                        if (null != vibrator)
                            vibrator.vibrate(500);
                    if (isSound)
                        // 播放音频，第二个参数为左声道音量;第三个参数为右声道音量;第四个参数为优先级；第五个参数为循环次数，0不循环，-1循环;第六个参数为速率，速率
                        // 最低0.5最高为2，1代表正常速度
                        if (null != pool) {
                            pool.play(sourceid, 1, 1, 0, 0, 1);
                        }
                    if (isAnimation)
                        if (null != view && null != animation) {
                            view.startAnimation(animation);
                        }
                    if (isAnimationDrawable)
                        if (null != aDrawable)
                            aDrawable.start();
                    HandlerPost();
                }

            }
        }

    }

    //修改晃动状态为false
    public void setNoShake(){
        isShaking=false;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
// TODO Auto-generated method stub
// 当传感器精度改变时回调该方法，Do nothing.
    }

}