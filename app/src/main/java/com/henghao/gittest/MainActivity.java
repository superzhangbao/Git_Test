package com.henghao.gittest;

import android.Manifest;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionListener;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, QRCodeView.Delegate {

    private static final String TAG = "MainActivity";
    @InjectView(R.id.start_spot)
    TextView startSpot;
    @InjectView(R.id.stop_spot)
    TextView stopSpot;
    @InjectView(R.id.show_rect)
    TextView showRect;
    @InjectView(R.id.hidden_rect)
    TextView hiddenRect;
    @InjectView(R.id.start_spot_showrect)
    TextView startSpotShowrect;
    @InjectView(R.id.stop_spot_hiddenrect)
    TextView stopSpotHiddenrect;
    @InjectView(R.id.start_preview)
    TextView startPreview;
    @InjectView(R.id.stop_preview)
    TextView stopPreview;
    @InjectView(R.id.scan_barcode)
    TextView scanBarcode;
    @InjectView(R.id.scan_qrcode)
    TextView scanQrcode;
    @InjectView(R.id.open_flashlight)
    TextView openFlashlight;
    @InjectView(R.id.close_flashlight)
    TextView closeFlashlight;
    @InjectView(R.id.choose_qrcde_from_gallery)
    TextView chooseQrcdeFromGallery;
    private Button saoMiao;
    private ZXingView zXingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        zXingView = (ZXingView) findViewById(R.id.zxingview);
        AndPermission.with(this)
                .requestCode(100)
                .permission(Manifest.permission.CAMERA)
                .callback(new PermissionListener() {
                    @Override
                    public void onSucceed(int requestCode, @NonNull List<String> grantPermissions) {
                        if (requestCode == 100) {
                            Toast.makeText(MainActivity.this,"开启相机成功",Toast.LENGTH_SHORT).show();
                            zXingView.setDelegate(MainActivity.this);
                        }
                    }

                    @Override
                    public void onFailed(int requestCode, @NonNull List<String> deniedPermissions) {
                        if (requestCode == 100) {
                            Toast.makeText(MainActivity.this,"开启相机失败",Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                })
                .start();
        Log.i(TAG, "dev:1");
        Log.i(TAG, "dev_zb:1");
        Log.i(TAG, "dev_zb:2");
        Log.i(TAG, "dev_zb:3");
        Log.i(TAG, "版本一上线");
        Log.i(TAG, "1.1");
        Log.i(TAG, "1.2");
        Log.i(TAG, "版本2上线");
        Log.i(TAG, "2.1");
        Log.i(TAG, "2.2");
        Log.i(TAG, "版本3上线");
        Log.i(TAG, "3.1");
        Log.i(TAG, "3.2");
        Log.i(TAG, "3.3");
        Log.i(TAG, "3.4");
        Log.i(TAG, "3.5");
        Log.i(TAG, "版本4上线");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_spot:
                zXingView.startSpot();
                break;
            case R.id.stop_spot:
                zXingView.stopSpot();
                break;
            case R.id.start_spot_showrect:
                zXingView.startSpotAndShowRect();
                break;
            case R.id.stop_spot_hiddenrect:
                zXingView.stopSpotAndHiddenRect();
                break;
            case R.id.show_rect:
                zXingView.showScanRect();
                break;
            case R.id.hidden_rect:
                zXingView.hiddenScanRect();
                break;
            case R.id.start_preview:
                zXingView.startCamera();
                break;
            case R.id.stop_preview:
                zXingView.stopCamera();
                break;
            case R.id.open_flashlight:
                zXingView.openFlashlight();
                break;
            case R.id.close_flashlight:
                zXingView.closeFlashlight();
                break;
            case R.id.scan_barcode:
                zXingView.changeToScanBarcodeStyle();
                break;
            case R.id.scan_qrcode:
                zXingView.changeToScanQRCodeStyle();
                break;
            case R.id.choose_qrcde_from_gallery:
//                /*
//                从相册选取二维码图片，这里为了方便演示，使用的是
//                https://github.com/bingoogolapple/BGAPhotoPicker-Android
//                这个库来从图库中选择二维码图片，这个库不是必须的，你也可以通过自己的方式从图库中选择图片
//                 */
//                startActivityForResult(BGAPhotoPickerActivity.newIntent(this, null, 1, null, false), REQUEST_CODE_CHOOSE_QRCODE_FROM_GALLERY);
                break;
        }
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        Log.i(TAG, "result:" + result);
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        vibrate();
        zXingView.startSpot();
    }

    private void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }

    @Override
    public void onScanQRCodeOpenCameraError() {
        Log.i(TAG, "打开相机出错");
    }

    @Override
    protected void onStart() {
        super.onStart();
        zXingView.startCamera();
//        mQRCodeView.startCamera(Camera.CameraInfo.CAMERA_FACING_FRONT);

        zXingView.showScanRect();
    }

    @Override
    protected void onStop() {
        zXingView.stopCamera();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        zXingView.onDestroy();
        super.onDestroy();
    }

}
