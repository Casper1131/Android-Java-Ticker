package api.timers;

import android.os.Handler;

/**
 * Created by Casper1131 on 3/30/2016.
 */
public class Ticker {
    public final String TYPE = "LABEL";
    protected String label;
    protected int interval;
    protected int times;
    protected Handler handle;
    protected int count;
    protected TickCallback tfn;
    protected boolean stopped;
    protected Timer timer;
    StopCallback stopcall;
    public Ticker(int in,String la,int ti,final TickCallback fn, final StopCallback sn){
        //time between calls
		interval = in;
		//label of ticker
        label = la;
		//how many times should it run ,if 0 run forever
        times = ti;
		//how many times it has ran
        count = 0;
		//tick call back
        tfn = fn;
		//call back for when ticker is stopped
        stopcall = sn;
        handle = new Handler();
        stopped = false;
    }
    protected Runnable tickRunnable = new Runnable() {
        @Override
        public void run() {
            if((++count > times && times != 0)){
                stopcall.stop();
            }
            else{
                tfn.Tick(count);
                handle.postDelayed(tickRunnable, interval);
            }
        }
    };
    public String getLabel(){
        return label;
    }
    public void start(){
        handle.postDelayed(tickRunnable,interval);
    }
    public void stop(){
        handle.removeCallbacks(tickRunnable);
        stopped = true;
    }
}
