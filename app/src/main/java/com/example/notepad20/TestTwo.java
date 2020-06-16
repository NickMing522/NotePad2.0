package com.example.xutilsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xutilsdemo.User;
import org.xutils.DbManager;
import org.xutils.common.Callback;
import org.xutils.common.util.KeyValue;
import org.xutils.db.sqlite.WhereBuilder;
import org.xutils.ex.DbException;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.File;
import java.util.ArrayList;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
  //  DbManager db;
    String url = "https://i.picsum.photos/id/1/5616/3744.jpg";
    @ViewInject(R.id.img)
    ImageView iv;

    @ViewInject(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        ImageOptions options = new ImageOptions.Builder()
                .setFadeIn(true)
                .setCrop(true)
                .setSize(300,300).build();

        x.image().loadDrawable(url,options, new Callback.CommonCallback<Drawable>() {
            @Override
            public void onSuccess(Drawable result) {
                iv.setImageDrawable(result);
                tv.setText("图片加载成功");
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                tv.setText("图片加载错误");
            }

            @Override
            public void onCancelled(CancelledException cex) {
            }

            @Override
            public void onFinished() {
            }
        });

        x.image().loadFile(url, options, new Callback.CacheCallback<File>() {
            @Override
            public boolean onCache(File result) {
                //使用本地图片
                Log.i("test",result.getPath());
                return true;

            }

            @Override
            public void onSuccess(File result) {

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });





//        x.image().bind(iv, url,options, new Callback.CacheCallback<Drawable>() {
//            @Override
//            //缓存
//            public boolean onCache(Drawable result) {
//                return false;
//            }
//
//            @Override
//            public void onSuccess(Drawable result) {
//                tv.setText("图片加载成功");
//            }
//
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//                tv.setText("图片加载错误");
//            }
//
//            @Override
//            public void onCancelled(CancelledException cex) {
//
//            }
//
//            @Override
//            public void onFinished() {
//
//            }
//        });

       // setContentView(R.layout.activity_main);

//        DbManager.DaoConfig daoConfig = new DbManager.DaoConfig()
//                .setDbName("test.db")
//                .setDbDir(new File("/sdcard"))
//                .setDbVersion(2)
//                .setDbOpenListener(new DbManager.DbOpenListener() {
//                    @Override
//                    public void onDbOpened(DbManager db) throws DbException {
//                       //开启WAL，提升写入速度
//                        db.getDatabase().enableWriteAheadLogging();
//                    }
//                })
//                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
//                    @Override
//                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) throws DbException {
//                        //可进行建表等相关操作
//                    }
//                });
//
//
//        try {
//            db = x.getDb(daoConfig);
//        } catch (DbException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//    @Event(R.id.save)
//        private void save(View v) throws DbException {
//        ArrayList<User> users = new ArrayList<>();
//            users.add(new User("zhangsan"));
//            users.add(new User("lisi"));
//            //不仅仅可以进行单个用户的插入，还能实现List的插入
//            db.save(users);
//             Log.i("test","建表成功");
//
//    }
//
//    @Event(R.id.delete)
//    private void del(View v) throws DbException {
//        //whereBuilder即为一个条件类，在其中可以运行有条件的SQL语句
//        //传入id = 1
//        db.delete(User.class, WhereBuilder.b().and("id","=",1));
//        Log.i("test","删除成功");
//    }
//
//    @Event(R.id.update)
//    private void update(View v) throws DbException {
//        //将id=1的数据的name值改为Nick
//        db.update(User.class,WhereBuilder.b().and("id","=",1),new KeyValue("name","Nick"));
//        Log.i("test","修改成功");
//    }
//
//    @Event(R.id.query)
//    private void select(View v) throws DbException {
//        //查找出id=1的值
//       User user = db.selector(User.class).where("id","=",1).findFirst();
//        Log.i("test","用户名为："+user.getName());
//        Toast.makeText(getApplicationContext(),user.getName(),Toast.LENGTH_LONG).show();
//    }

//    @Event(value = {R.id.btn1,R.id.btn2,R.id.btn3})
//    private void onClick(View v) {
//        switch (v.getId()){
//            case R.id.btn1 :
//                Toast.makeText(getApplicationContext(),"btn1被点击了",Toast.LENGTH_LONG).show();
//            case R.id.btn2 :
//                Toast.makeText(getApplicationContext(),"btn2被点击了",Toast.LENGTH_LONG).show();
//            case R.id.btn3 :
//                Toast.makeText(getApplicationContext(),"btn3被点击了",Toast.LENGTH_LONG).show();
//        }
//    }

//    @ViewInject(R.id.tv)
//    TextView tv;
//    @Event(R.id.get)
//    public void Get(View v){
//        String url = "http://apis.baidu.com/heweather/weather/free";
//        RequestParams params = new RequestParams(url);
//        //添加参数
//        params.addQueryStringParameter("username","zahngsan");
//        params.addQueryStringParameter("password","1234");
//
//        x.http().get(params, new Callback.CacheCallback<String>() {
//            //成功
//            @Override
//            public void onSuccess(String result) {
//
//            }
//            //失败
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//
//            }
//            //主动取消回调
//            @Override
//            public void onCancelled(CancelledException cex) {
//
//            }
//            //请求完成的回调
//            @Override
//            public void onFinished() {
//
//            }
//            //缓存
//            @Override
//            public boolean onCache(String result) {
//                return false;
//            }
//        });
    }

//    @Event(R.id.down)
//    private void down(View v){
//        String url = "https://down.qq.com/qqweb/QQ_1/android_apk/Android_8.3.6.4590_537064458.apk";
//
//        RequestParams params = new RequestParams(url);
//        //定义存储的目录
//        params.setSaveFilePath(Environment.getExternalStorageDirectory()+"/test");
//        //设置文件自动命名
//        params.setAutoRename(true);
//
//        x.http().post(params, new Callback.ProgressCallback<File>() {
//            @Override
//            public void onSuccess(File result) {
//                //apk下载完成后，调用系统的安装方法
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setDataAndType(Uri.fromFile(result), "application/vnd.android.package-archive");
//                startActivity(intent);
//            }
//
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//
//            }
//
//            @Override
//            public void onCancelled(CancelledException cex) {
//
//            }
//
//            @Override
//            public void onFinished() {
//
//            }
//            //网络请求之前的回调
//            @Override
//            public void onWaiting() {
//
//            }
//            //开始请求的回调
//            @Override
//            public void onStarted() {
//
//            }
//            //边请求边调用的方法
//            @Override
//            public void onLoading(long total, long current, boolean isDownloading) {
//                Log.i("test","current="+",total="+total);
//            }
//        });
//    }





}
