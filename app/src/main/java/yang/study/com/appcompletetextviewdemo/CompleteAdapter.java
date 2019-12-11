package yang.study.com.appcompletetextviewdemo;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.List;

public class CompleteAdapter extends BaseAdapter implements Filterable {
    private final Context context;
    private final List<ProvinceModel> provinceModelList;

    public CompleteAdapter(Context context, List<ProvinceModel> provinceModelList) {
        this.context = context;
        this.provinceModelList = provinceModelList;
        Log.e("Filter::", "CompleteAdapter::CompleteAdapter==");
    }

    public void setData(Object objects) {
        provinceModelList.clear();
        if (objects != null) {
            List<ProvinceModel> provinceModelListResult = (List<ProvinceModel>) objects;
            provinceModelList.addAll(provinceModelListResult);
            notifyDataSetChanged();
        } else {
            notifyDataSetInvalidated();
        }
        Log.e("Filter::", "CompleteAdapter::setData==");
    }

    @Override
    public int getCount() {
        Log.e("Filter::", "CompleteAdapter::getCount==");
        return provinceModelList == null ? 0 : provinceModelList.size();
    }

    @Override
    public ProvinceModel getItem(int position) {
        Log.e("Filter::", "CompleteAdapter::getItem==");
        return provinceModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        Log.e("Filter::", "CompleteAdapter::getItemId==");
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.e("Filter::", "CompleteAdapter::getView==");
        if (convertView == null) {
            convertView = View.inflate(context, android.R.layout.simple_list_item_1, null);
        }
        TextView tv = (TextView) convertView;
        tv.setText(position + "数据id==" + getItem(position).provinceName);
        return convertView;
    }

    /**
     * 给AppCompatAutoCompleteTextView设置Adapter之后就会被调用
     * @return
     */
    @Override
    public Filter getFilter() {
        Log.e("Filter::", "CompleteAdapter::getFilter==");
        return new CompleteFilterable(provinceModelList, this);
    }
}
