package yang.study.com.appcompletetextviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.util.TypedValue;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppCompatAutoCompleteTextView acactv;
    private List<ProvinceModel> provinceModelList = new ArrayList<>();
    private String[] provinceNames = {
            "深圳市大疆创新科技公司",
            "深圳市华为制造公司",
            "深圳华为控股公司",
            "深圳市飘飘宝贝公司",
            "深圳市娃哈哈投资公司",
            "深圳市中金岭南有色金属股份有限公司",
            "深圳能源集团股份有限公司",
            "深圳市神州通投资集团有限公司",
            "长沙市芒果tv公司",
            "长沙市三一重工集团",
            "长沙计算机公司",
            "长沙市知否知否公司",
            "长沙市喜喜咨询公司"
    };
    private CompleteAdapter completeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 10; i++) {
            ProvinceModel provinceModel = new ProvinceModel();
            provinceModel.provinceName = provinceNames[i];
            provinceModel.provinceId = i;
            provinceModelList.add(provinceModel);
        }
        acactv = findViewById(R.id.acactv);
        acactv.setBackgroundResource(R.color.colorPrimaryDark);
       // acactv.setDropDownVerticalOffset((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,12f,getResources().getDisplayMetrics()));
        completeAdapter = new CompleteAdapter(this, provinceModelList);
        acactv.setAdapter(completeAdapter);
    }
}
