package com.example.administrator.xinning_wcs;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;


import com.example.administrator.xinning_wcs.adapter.CntAdapter;
import com.example.administrator.xinning_wcs.adapter.CntAdapter2;
import com.example.administrator.xinning_wcs.adapter.CntAdapter3;
import com.example.administrator.xinning_wcs.adapter.CntAdapter4;
import com.example.administrator.xinning_wcs.object.FenjiankouObject;
import com.example.administrator.xinning_wcs.object.NameObject;
import com.example.administrator.xinning_wcs.object.YnObject2;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class KanbanActivity extends AppCompatActivity {

    @InjectView(R.id.resuTextView)
    TextView resuTextView;
    @InjectView(R.id.bundleTextView)
    TextView bundleTextView;
    @InjectView(R.id.overpackTextView)
    TextView overpackTextView;

    private CntAdapter cntAdapter;//库存信息的Adapter
    private List<FenjiankouObject> fenjianList = new ArrayList<>();
    private ListView listView;


    private CntAdapter2 cntAdapter2;//库存信息的Adapter
    private ListView listView2;
    private List<String> resu;//分型线
    private List<String> bundle;//门体型号
    private List<String> overpack;//库存

    private CntAdapter3 cntAdapter3;//库存信息的Adapter
    private ListView listView3;
    private List<YnObject2> ynList2 = new ArrayList<>();

    private CntAdapter4 cntAdapter4;//库存信息的Adapter
    private ListView listView4;
    private List<NameObject> nameList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kanban);
        ButterKnife.inject(this);
        listView = (ListView) findViewById(R.id.listview);
        listView2 = (ListView) findViewById(R.id.listview2);
        listView3 = (ListView) findViewById(R.id.listview3);
        listView4 = (ListView) findViewById(R.id.listview4);
        get1();
        //get2();
        get3();
        get4();
        spark();

    }

    private int clo = 0;
    public void spark() {
         Timer timer = new Timer();
         TimerTask taskcc = new TimerTask(){
             public void run() {
                 runOnUiThread(new Runnable() {
                    public void run() {
                        if (clo == 0) {
                            clo = 1;
                            resuTextView.setTextColor(Color.TRANSPARENT); // 透明
                            } else {
                            if (clo == 1) {
                                clo = 2;
                                resuTextView.setTextColor(Color.RED);
                                } else {
                                clo = 0;
                                resuTextView.setTextColor(Color.GREEN);
                                }
                            }
                        }
                    });
                }
            };
        timer.schedule(taskcc, 1, 300);
        // 参数分别是delay(多长时间后执行)，duration(执行间隔)
        }


    public void get1() {
        FenjiankouObject fenjiankouObject = new FenjiankouObject();
        fenjiankouObject.setLiaohao("AIVL112345");
        fenjiankouObject.setPo("123456789");
        fenjiankouObject.setPo_line("00010");
        fenjiankouObject.setPo_allnum("1000");
        fenjiankouObject.setNo_num("300");
        fenjiankouObject.setAllban_num("72");
        fenjiankouObject.setWeiban_num("48");
        fenjiankouObject.setFenjian_model("立库");
        fenjianList.add(fenjiankouObject);
        Log.d("QQ", fenjiankouObject.getAllban_num());
        cntAdapter = new CntAdapter(fenjianList, KanbanActivity.this);
        listView.setAdapter(cntAdapter);

    }

    public void get2() {
        resu = new ArrayList<String>();
        bundle = new ArrayList<String>();
        overpack = new ArrayList<String>();
        resu.add("Y");
        bundle.add("N");
        overpack.add("N");
        cntAdapter2 = new CntAdapter2(resu, bundle, overpack, KanbanActivity.this);
        listView2.setAdapter(cntAdapter2);
    }

    public void get3() {
        YnObject2 ynObject2 = new YnObject2();
        ynObject2.setMrp("N");
        ynObject2.setGtin("N");
        ynObject2.setPrc("N");
        ynList2.add(ynObject2);
        cntAdapter3 = new CntAdapter3(ynList2, KanbanActivity.this);
        listView3.setAdapter(cntAdapter3);
    }

    public void get4() {
//        nameObject.setName("天地盖");
//        nameObject.setName("围套");
//        nameObject.setName("烟囱");
//        nameObject.setName("围套");
//        nameObject.setName("烟囱");
//        nameObject.setName("护角");
        for (int j = 1; j < 8; j++) {
            NameObject nameObject = new NameObject();
            nameObject.setName("栈板"+ j);
            nameObject.setLiaohao2("123456789" + j);
            nameObject.setName2("00010");
            nameList.add(nameObject);
        }

        cntAdapter4 = new CntAdapter4(nameList, KanbanActivity.this);
        listView4.setAdapter(cntAdapter4);
    }


}
