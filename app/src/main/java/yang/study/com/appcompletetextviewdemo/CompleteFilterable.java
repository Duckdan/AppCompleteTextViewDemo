package yang.study.com.appcompletetextviewdemo;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

public class CompleteFilterable extends Filter {
    private List<ProvinceModel> provinceModelList = new ArrayList<>();
    private CompleteAdapter completeAdapter;

    public CompleteFilterable(List<ProvinceModel> provinceModelList, CompleteAdapter completeAdapter) {
        this.provinceModelList.addAll(provinceModelList);
        this.completeAdapter = completeAdapter;
        Log.e("Filter::", "CompleteFilterable::CompleteFilterable==");
    }

    /**
     * 执行过滤
     * 如果采取服务器端过滤之后返回结果，那么该方法不用执行
     * 任何过滤操作。只需要将查询结果赋值给FilterResults即可
     *
     * @param constraint
     * @return
     */
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        Log.e("Filter::", "CompleteFilterable::performFiltering==" + constraint);
        FilterResults filterResults = new FilterResults();
        ArrayList<ProvinceModel> provinceModelArrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(constraint)) {
            for (int i = 0; i < provinceModelList.size(); i++) {
                ProvinceModel provinceModel = provinceModelList.get(i);
                if (provinceModel.provinceName.contains(constraint)) {
                    provinceModelArrayList.add(provinceModel);
                }
            }
        }
        filterResults.count = provinceModelArrayList.size();
        filterResults.values = provinceModelArrayList;
        return filterResults;
    }

    /**
     * 发布过滤结果
     *
     * @param constraint
     * @param results
     */
    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        Log.e("Filter::", "CompleteFilterable::publishResults==" + constraint + "，" + (results == null ? null : (results.count + "==" + results.values)));
        completeAdapter.setData(results.values);
    }

    /**
     * 点击联想搜索结果条目的时候使用
     *
     * @param resultValue
     * @return
     */
    @Override
    public CharSequence convertResultToString(Object resultValue) {
        return resultValue == null ? "" : ((ProvinceModel) resultValue).provinceName;
    }
}
