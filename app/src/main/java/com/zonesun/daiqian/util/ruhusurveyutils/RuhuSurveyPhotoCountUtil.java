package com.zonesun.daiqian.util.ruhusurveyutils;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.BitmapUtils;
import com.zonesun.daiqian.activity.R;
import com.zonesun.daiqian.adapter.PopAdapter;
import com.zonesun.daiqian.fragment.RuhuSurveyFragment;
import com.zonesun.daiqian.util.Constants;
import com.zonesun.daiqian.util.ToastUtil;
import com.zonesun.daiqian.view.BadgeView;

import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/16 0016.
 */

public class RuhuSurveyPhotoCountUtil implements AdapterView.OnItemLongClickListener {

    RuhuSurveyFragment fragment;

    public RuhuSurveyPhotoCountUtil(RuhuSurveyFragment fragment) {
        this.fragment = fragment;
    }

    /**
     * 初始化popwindow 显示从网络获取的图片并可以对图片进行，增删操作；
     */
    public void initPopup(List<String> networkList,
                          ArrayList<String> localList, View v) {

        fragment. viewBadge = (ImageView) v;

        if (localList != null && localList.size() > 0 && networkList != null
                && networkList.size() > 0) {
            fragment. networkpaList = networkList;
            fragment.locapalList = localList;
            fragment. mList = new ArrayList<String>();
            fragment. localListSize = localList.size();
            fragment. networkListSize = networkList.size();
            for (String path : localList) {
                fragment. mList.add(path);
            }
            for (String path : networkList) {
                fragment.mList.add(Constants.GETIMGURL + path);
            }
        } else if (localList != null && localList.size() > 0) {
            fragment. mList = localList;
        } else if (networkList != null && networkList.size() > 0) {
            fragment.mList = new ArrayList<String>();
            fragment. networkpaList = networkList;
            fragment. networkListSize = fragment.networkpaList.size();
            for (String url : networkList) {
                fragment. mList.add(Constants.GETIMGURL + url);
            }

        } else {

            ToastUtil.showShort(fragment.getActivity(), "请先添加照片");
            return;
        }

        //
        fragment. mListView = new ListView(fragment.getActivity());
        // mListView.setDivider(null);
        fragment. mListView.setOnItemLongClickListener(this);
        fragment.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                fragment. mPopup.dismiss();

            }
        });

        fragment.  mPopAdapter = new PopAdapter(fragment.getActivity(), fragment.mList);
        fragment. mListView.setAdapter(fragment.mPopAdapter);
        fragment. mListView.setBackgroundColor(Color.GRAY);
        fragment. mPopup = new PopupWindow(fragment.mListView, v.getWidth() * 2,
                LinearLayout.LayoutParams.WRAP_CONTENT, true);

        fragment. mPopup.setOutsideTouchable(true);
        // mPopup.setFocusable(true);
        fragment.  mPopup.setBackgroundDrawable(new BitmapDrawable());
        fragment.   mPopup.showAsDropDown(v, 0, 0);

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view,
                                   int position, long id) {
        // TODO Auto-generated method stub
        // sfzlList, sfzzmLis
        fragment.mList.remove(position);// 如果是新添加申请用户则可以用来删除不清晰的照片
        // 如果是需要将已走访的用户照片信息用作修改下边两个是同时修改，想要添加的照片，和已经提交到服务器的照片
        if (fragment.localListSize != 0 && fragment.localListSize > position) {

            fragment.locapalList.remove(position);
        } else if (fragment.networkListSize != 0) {// 此步骤有重复利用的结果
            fragment.networkpaList.remove(position - fragment.localListSize);

        }

        // 此步是仅当用户需要修改已走访人的照片而不需要重新采集新照片时这样会走这个逻辑
        switch (fragment.viewBadge.getId()) {
            // 身份资料
            case R.id.sfzzm_imageview:
                // (sfzlList, sfzzmList
                fragment.msfzlList = fragment.mList;

                if (fragment.sfzlList != null && fragment.sfzlList.size() > 0
                        && fragment.sfzzmList.size() == 0) {
                    if (fragment.sfzlbnv != null && fragment.nameValuePairs.contains(fragment.sfzlbnv)) {
                        fragment.nameValuePairs.remove(fragment.sfzlbnv);
                        fragment.sfzlbnv = new BasicNameValuePair("cert1_url",
                                new Gson().toJson(fragment.networkpaList));
                        fragment.nameValuePairs.add(fragment.sfzlbnv);
                    } else {
                        fragment.nameValuePairs.remove(fragment.sfzlbnv);
                        fragment.sfzlbnv = new BasicNameValuePair("cert1_url",
                                new Gson().toJson(fragment.networkpaList));
                        fragment.nameValuePairs.add(fragment.sfzlbnv);
                    }
                } else {
                    if (fragment.sfzlbnv != null && fragment.nameValuePairs.contains(fragment.sfzlbnv)) {
                        fragment.nameValuePairs.remove(fragment.sfzlbnv);
                        fragment.sfzlbnv = new BasicNameValuePair("cert1_url", "null");
                        fragment.nameValuePairs.add(fragment.sfzlbnv);

                    } else {

                        fragment.sfzlbnv = new BasicNameValuePair("cert1_url", "null");
                        fragment.nameValuePairs.add(fragment.sfzlbnv);
                        System.out.println(fragment.nameValuePairs.toString());
                    }
                }
                break;
            // 地址详情
            case R.id.sfzfm_imageview:
                fragment.mdzxxList = fragment.mList;
                if (fragment.dzxqList != null && fragment.dzxqList.size() > 0
                        && fragment.sfzfmList.size() == 0) {
                    if (fragment.dzxqbnv != null && fragment.nameValuePairs.contains(fragment.dzxqbnv)) {
                        fragment.nameValuePairs.remove(fragment.dzxqbnv);
                        fragment.dzxqbnv = new BasicNameValuePair("cert2_url",
                                new Gson().toJson(fragment.networkpaList));
                        fragment.nameValuePairs.add(fragment.dzxqbnv);
                    } else {
                        fragment.dzxqbnv = new BasicNameValuePair("cert2_url",
                                new Gson().toJson(fragment.networkpaList));
                        fragment.nameValuePairs.add(fragment.dzxqbnv);
                    }

                } else {
                    if (fragment.dzxqbnv != null && fragment.nameValuePairs.contains(fragment.dzxqbnv)) {
                        fragment.nameValuePairs.remove(fragment.dzxqbnv);
                        fragment.dzxqbnv = new BasicNameValuePair("cert2_url", "null");
                        fragment.nameValuePairs.add(fragment.dzxqbnv);

                    } else {

                        fragment.dzxqbnv = new BasicNameValuePair("cert2_url", "null");
                        fragment.nameValuePairs.add(fragment.dzxqbnv);

                    }

                }

                break;
            // 地图定位
            case R.id.scsfz_imageview:
                // dzdwList,scsfzmList dtdwbnv
                fragment.mdwList = fragment.mList;
                if (fragment.dzdwList != null && fragment.dzdwList.size() > 0
                        && fragment.scsfzmList.size() == 0) {
                    if (fragment.dtdwbnv != null && fragment.nameValuePairs.contains(fragment.dtdwbnv)) {
                        fragment.nameValuePairs.remove(fragment.dtdwbnv);
                        fragment.dtdwbnv = new BasicNameValuePair("cert3_url",
                                new Gson().toJson(fragment.networkpaList));
                        fragment.nameValuePairs.add(fragment.dtdwbnv);
                    } else {
                        fragment.dtdwbnv = new BasicNameValuePair("cert3_url",
                                new Gson().toJson(fragment.networkpaList));
                        fragment.nameValuePairs.add(fragment.dtdwbnv);
                    }
                } else {
                    if (fragment.dtdwbnv != null && fragment.nameValuePairs.contains(fragment.dtdwbnv)) {
                        fragment.nameValuePairs.remove(fragment.dtdwbnv);
                        fragment.dtdwbnv = new BasicNameValuePair("cert3_url", "null");
                        fragment.nameValuePairs.add(fragment.dtdwbnv);
                    } else {
                        fragment.dtdwbnv = new BasicNameValuePair("cert3_url", "null");
                        fragment.nameValuePairs.add(fragment.dtdwbnv);
                    }
                }
                break;
            // 收入文件证明
            case R.id.ydcyhy_imageview:

                // srwjzmList srwjzmbnv
                fragment.msrzmlList = fragment.mList;
                // 判断当不需要重新添加照片而只需要修改数据库中的照片时；
                if (fragment.srwjzmList != null && fragment.srwjzmList.size() > 0
                        && fragment.ydcyhyList.size() == 0) {
                    if (fragment.srwjzmbnv != null && fragment.nameValuePairs.contains(fragment.srwjzmbnv)) {
                        fragment.nameValuePairs.remove(fragment.srwjzmbnv);
                        fragment.srwjzmbnv = new BasicNameValuePair("togather_url",
                                new Gson().toJson(fragment.networkpaList));
                        fragment.nameValuePairs.add(fragment.srwjzmbnv);
                    } else {
                        fragment.srwjzmbnv = new BasicNameValuePair("togather_url",
                                new Gson().toJson(fragment.networkpaList));
                        fragment.nameValuePairs.add(fragment.srwjzmbnv);
                    }
                } else {
                    if (fragment.srwjzmbnv != null && fragment.nameValuePairs.contains(fragment.srwjzmbnv)) {
                        fragment.nameValuePairs.remove(fragment.srwjzmbnv);
                        fragment.srwjzmbnv = new BasicNameValuePair("togather_url", "null");
                        fragment.nameValuePairs.add(fragment.srwjzmbnv);
                    } else {
                        fragment.srwjzmbnv = new BasicNameValuePair("togather_url", "null");
                        fragment.nameValuePairs.add(fragment.srwjzmbnv);
                    }

                }
                break;

            // 购车发票文件
            case R.id.zzzm_imageView:
                fragment.mgcfpList = fragment.mList;
                // initPopup(zzzmList, v);gcfpwjzmList gcfpwjbnv
                if (fragment.gcfpwjzmList != null && fragment.gcfpwjzmList.size() > 0
                        && fragment.zzzmList.size() == 0) {
                    if (fragment.gcfpwjbnv != null && fragment.nameValuePairs.contains(fragment.gcfpwjbnv)) {
                        fragment.nameValuePairs.remove(fragment.gcfpwjbnv);
                        fragment.gcfpwjbnv = new BasicNameValuePair("zzzm_url",
                                new Gson().toJson(fragment.networkpaList));
                        fragment.nameValuePairs.add(fragment.gcfpwjbnv);
                    } else {
                        fragment.gcfpwjbnv = new BasicNameValuePair("zzzm_url",
                                new Gson().toJson(fragment.networkpaList));
                        fragment.nameValuePairs.add(fragment.gcfpwjbnv);
                    }
                } else {
                    if (fragment.gcfpwjbnv != null && fragment.nameValuePairs.contains(fragment.gcfpwjbnv)) {
                        fragment.nameValuePairs.remove(fragment.gcfpwjbnv);
                        fragment.gcfpwjbnv = new BasicNameValuePair("zzzm_url", "null");
                        fragment.nameValuePairs.add(fragment.gcfpwjbnv);
                    } else {
                        fragment.gcfpwjbnv = new BasicNameValuePair("zzzm_url", "null");
                        fragment.nameValuePairs.add(fragment.gcfpwjbnv);
                    }

                }
                break;

            // 首付款证明文件
            case R.id.sqrxq_imageView:

                fragment.msfkList = fragment.mList;
                // initPopup(sqrxqList, v);sfkwjzmList sfkzmwjbnv
                if (fragment.sfkwjzmList != null && fragment.sfkwjzmList.size() > 0
                        && fragment.sqrxqList.size() == 0) {
                    if (fragment.sfkzmwjbnv != null && fragment.nameValuePairs.contains(fragment.sfkzmwjbnv)) {
                        fragment.nameValuePairs.remove(fragment.sfkzmwjbnv);
                        fragment.sfkzmwjbnv = new BasicNameValuePair("xq_url",
                                new Gson().toJson(fragment.networkpaList));
                        fragment.nameValuePairs.add(fragment.sfkzmwjbnv);
                    } else {
                        fragment.sfkzmwjbnv = new BasicNameValuePair("xq_url",
                                new Gson().toJson(fragment.networkpaList));
                        fragment.nameValuePairs.add(fragment.sfkzmwjbnv);
                    }
                } else {
                    if (fragment.sfkzmwjbnv != null && fragment.nameValuePairs.contains(fragment.sfkzmwjbnv)) {
                        fragment.nameValuePairs.remove(fragment.sfkzmwjbnv);
                        fragment.sfkzmwjbnv = new BasicNameValuePair("xq_url", "null");
                        fragment.nameValuePairs.add(fragment.sfkzmwjbnv);
                    } else {
                        fragment.sfkzmwjbnv = new BasicNameValuePair("xq_url", "null");
                        fragment.nameValuePairs.add(fragment.sfkzmwjbnv);
                    }
                }
                break;

            // 车辆抵押证明文件
            case R.id.sqrszlh_imageView:
                fragment.mcldyList = fragment.mList;
                // initPopup(sqrszlhList, v);cldiwjzmList cldiwjzmbnv
                if (fragment.cldiwjzmList != null && fragment.cldiwjzmList.size() > 0
                        && fragment.sqrszlhList.size() == 0) {
                    if (fragment.cldiwjzmbnv != null && fragment.nameValuePairs.contains(fragment.cldiwjzmbnv)) {
                        fragment.nameValuePairs.remove(fragment.cldiwjzmbnv);
                        fragment.cldiwjzmbnv = new BasicNameValuePair("lh_url",
                                new Gson().toJson(fragment.networkpaList));
                        fragment.nameValuePairs.add(fragment.cldiwjzmbnv);
                    } else {
                        fragment.cldiwjzmbnv = new BasicNameValuePair("lh_url",
                                new Gson().toJson(fragment.networkpaList));
                        fragment.nameValuePairs.add(fragment.cldiwjzmbnv);
                    }
                } else {
                    if (fragment.cldiwjzmbnv != null && fragment.nameValuePairs.contains(fragment.cldiwjzmbnv)) {
                        fragment.nameValuePairs.remove(fragment.cldiwjzmbnv);
                        fragment.cldiwjzmbnv = new BasicNameValuePair("lh_url", "null");
                        fragment.nameValuePairs.add(fragment.cldiwjzmbnv);
                    } else {
                        fragment.cldiwjzmbnv = new BasicNameValuePair("lh_url", "null");
                        fragment.nameValuePairs.add(fragment.cldiwjzmbnv);
                    }
                }
                break;
            // 车辆保险单文件
            case R.id.sqrszdy_imageView:
                fragment.mclbxList = fragment.mList;
                // initPopup(sqrszdyList, v);clbxdwjList clbxdwjbnv
                if (fragment.clbxdwjList != null && fragment.clbxdwjList.size() > 0
                        && fragment.sqrszdyList.size() == 0) {
                    if (fragment.clbxdwjbnv != null && fragment.nameValuePairs.contains(fragment.clbxdwjbnv)) {
                        fragment.nameValuePairs.remove(fragment.clbxdwjbnv);
                        fragment.clbxdwjbnv = new BasicNameValuePair("dy_url",
                                new Gson().toJson(fragment.networkpaList));
                        fragment.nameValuePairs.add(fragment.clbxdwjbnv);
                    } else {
                        fragment.clbxdwjbnv = new BasicNameValuePair("dy_url",
                                new Gson().toJson(fragment.networkpaList));
                        fragment.nameValuePairs.add(fragment.clbxdwjbnv);
                    }

                } else {
                    if (fragment.clbxdwjbnv != null && fragment.nameValuePairs.contains(fragment.clbxdwjbnv)) {
                        fragment.nameValuePairs.remove(fragment.clbxdwjbnv);
                        fragment.clbxdwjbnv = new BasicNameValuePair("dy_url", "null");
                        fragment.nameValuePairs.add(fragment.clbxdwjbnv);
                    } else {
                        fragment.clbxdwjbnv = new BasicNameValuePair("dy_url", "null");
                        fragment.nameValuePairs.add(fragment.clbxdwjbnv);
                    }

                }
                break;

            // 购车合同文件
            case R.id.sqrszmph_imageView:
                fragment.mgchtList = fragment.mList;
                // initPopup(sqrszmphList, v);gchewjzmList
                if (fragment.gchewjzmList != null && fragment.gchewjzmList.size() > 0
                        && fragment.sqrszmphList.size() == 0) {
                    if (fragment.gchtbnv != null && fragment.nameValuePairs.contains(fragment.gchtbnv)) {
                        fragment.nameValuePairs.remove(fragment.gchtbnv);
                        fragment.gchtbnv = new BasicNameValuePair("mph_url",
                                new Gson().toJson(fragment.networkpaList));
                        fragment.nameValuePairs.add(fragment.gchtbnv);
                    } else {
                        fragment.gchtbnv = new BasicNameValuePair("mph_url",
                                new Gson().toJson(fragment.networkpaList));
                        fragment.nameValuePairs.add(fragment.gchtbnv);
                    }
                } else {
                    if (fragment.gchtbnv != null && fragment.nameValuePairs.contains(fragment.gchtbnv)) {
                        fragment.nameValuePairs.remove(fragment.gchtbnv);
                        fragment.gchtbnv = new BasicNameValuePair("mph_url", "null");
                        fragment.nameValuePairs.add(fragment.gchtbnv);
                    } else {
                        fragment.gchtbnv = new BasicNameValuePair("mph_url", "null");
                        fragment.nameValuePairs.add(fragment.gchtbnv);
                    }

                }
                break;

            // 征信报告文件
            case R.id.dw_imageView:
                fragment.mzxbgList = fragment.mList;
                // initPopup(dwList, v);zxbgwjzmList zxbgbnv
                if (fragment.zxbgwjzmList != null && fragment.zxbgwjzmList.size() > 0
                        && fragment.dwList.size() == 0) {
                    if (fragment.zxbgbnv != null && fragment.nameValuePairs.contains(fragment.zxbgbnv)) {
                        fragment.nameValuePairs.remove(fragment.zxbgbnv);
                        fragment.zxbgbnv = new BasicNameValuePair("dw_url",
                                new Gson().toJson(fragment.networkpaList));
                        fragment.nameValuePairs.add(fragment.zxbgbnv);
                    } else {
                        fragment.zxbgbnv = new BasicNameValuePair("dw_url",
                                new Gson().toJson(fragment.networkpaList));
                        fragment.nameValuePairs.add(fragment.zxbgbnv);
                    }
                } else {
                    if (fragment.zxbgbnv != null && fragment.nameValuePairs.contains(fragment.zxbgbnv)) {
                        fragment.nameValuePairs.remove(fragment.zxbgbnv);
                        fragment.zxbgbnv = new BasicNameValuePair("dw_url", "null");
                        fragment.nameValuePairs.add(fragment.zxbgbnv);
                    } else {
                        fragment.zxbgbnv = new BasicNameValuePair("dw_url", "null");
                        fragment.nameValuePairs.add(fragment.zxbgbnv);
                    }
                }

                break;
            default:
                break;

        }
        System.out.println(position);
        fragment.localListSize = 0;
        fragment.networkListSize = 0;
        fragment.mPopup.dismiss();
        BadgeView badge = ((BadgeView) fragment.viewBadge.getTag());

        if (fragment.mList.size() == 0) {

            badge.hide();
        } else {
            badge.setText(fragment.mList.size() + "");
            badge.show();
        }
        return false;

    }

    /**
     * 展示图片
     *
     * @param url
     * 图片的名称
     * @param imageView
     * 展示图片的imagview
     */



    public void showImages(String url, ImageView imageView, int flag) {

        System.out.println(url);
        String result = url.replace("[", "").replace("]", "").replace("\"", "");

        BitmapUtils bitmapUtils = new BitmapUtils(fragment.getActivity());

        switch (flag) {
            case 1:
                if (fragment.badgeSfzzm == null) {
                    fragment.badgeSfzzm = new BadgeView(  fragment.getActivity(), imageView);
                    imageView.setTag(  fragment.badgeSfzzm);
                } else {
                    fragment.badgeSfzzm = (BadgeView) imageView.getTag();
                }
                fragment.badge3 =   fragment.badgeSfzzm;
                fragment. sfzlList = new Gson().fromJson(url, new TypeToken<List<String>>() {
                }.getType());

                break;
            case 2:
                if (  fragment.badgesfzfm == null) {
                    fragment.badgesfzfm = new BadgeView(  fragment.getActivity(), imageView);
                    imageView.setTag(  fragment.badgesfzfm);
                } else {
                    fragment. badgesfzfm = (BadgeView) imageView.getTag();
                }
                fragment.badge3 =   fragment.badgesfzfm;
                fragment. dzxqList = new Gson().fromJson(url, new TypeToken<List<String>>() {
                }.getType());
                break;
            case 3:
                if ( fragment.badgescsfzm == null) {

                    fragment. badgescsfzm = new BadgeView(fragment.getActivity(), imageView);
                    imageView.setTag(fragment.badgescsfzm);

                } else {
                    fragment.badgescsfzm = (BadgeView) imageView.getTag();
                }
                fragment.badge3 = fragment.badgescsfzm;
                fragment.dzdwList = new Gson().fromJson(url, new TypeToken<List<String>>() {
                }.getType());
                break;
            case 4:
                if (fragment.badgeydcyhy == null) {

                    fragment.badgeydcyhy = new BadgeView(fragment.getActivity(), imageView);
                    imageView.setTag(fragment.badgeydcyhy);
                } else {
                    fragment.badgeydcyhy = (BadgeView) imageView.getTag();
                }
                fragment.badge3 = fragment.badgeydcyhy;
                fragment.srwjzmList = new Gson().fromJson(url,
                        new TypeToken<List<String>>() {
                        }.getType());
                break;
            case 5:
                if (fragment.badgezzzm == null) {

                    fragment. badgezzzm = new BadgeView(fragment.getActivity(), imageView);
                    imageView.setTag(fragment.badgezzzm);
                } else {

                    fragment.badgezzzm = (BadgeView) imageView.getTag();
                }
                fragment.badge3 = fragment.badgezzzm;
                fragment.gcfpwjzmList = new Gson().fromJson(url,
                        new TypeToken<List<String>>() {
                        }.getType());
                break;
            case 6:
                if (fragment.badgesqrxq == null) {

                    fragment. badgesqrxq = new BadgeView(fragment.getActivity(), imageView);
                    imageView.setTag(fragment.badgesqrxq);
                } else {

                    fragment.badgesqrxq = (BadgeView) imageView.getTag();
                }
                fragment.badge3 = fragment.badgesqrxq;
                fragment. sfkwjzmList = new Gson().fromJson(url,
                        new TypeToken<List<String>>() {
                        }.getType());
                break;
            case 7:

                if (fragment.badgesqrszl == null) {

                    fragment. badgesqrszl = new BadgeView(fragment.getActivity(), imageView);
                    imageView.setTag(fragment.badgesqrszl);
                } else {

                    fragment.badgesqrszl = (BadgeView) imageView.getTag();
                }
                fragment.badge3 =fragment. badgesqrszl;
                fragment.cldiwjzmList = new Gson().fromJson(url,
                        new TypeToken<List<String>>() {
                        }.getType());
                break;
            case 8:
                if (fragment.badgesqrszdy == null) {

                    fragment.badgesqrszdy = new BadgeView(fragment.getActivity(), imageView);
                    imageView.setTag(fragment.badgesqrszdy);
                } else {

                    fragment.badgesqrszdy = (BadgeView) imageView.getTag();
                }
                fragment.badge3 =fragment. badgesqrszdy;
                fragment.clbxdwjList = new Gson().fromJson(url,
                        new TypeToken<List<String>>() {
                        }.getType());
                break;
            case 9:

                if (fragment.badgesqrszmph == null) {

                    fragment. badgesqrszmph = new BadgeView(fragment.getActivity(), imageView);
                    imageView.setTag(fragment.badgesqrszmph);
                } else {

                    fragment. badgesqrszmph = (BadgeView) imageView.getTag();
                }
                fragment.badge3 = fragment.badgesqrszmph;

                fragment.gchewjzmList = new Gson().fromJson(url,
                        new TypeToken<List<String>>() {
                        }.getType());
                // System.out.println("购车合同..."+gchewjzmList.toString());
                break;
            case 10:
                if (fragment.badgedw == null) {

                    fragment. badgedw = new BadgeView(fragment.getActivity(), imageView);
                    imageView.setTag(fragment.badgedw);
                } else {

                    fragment.badgedw = (BadgeView) imageView.getTag();
                }
                fragment.badge3 =fragment. badgedw;
                fragment. zxbgwjzmList = new Gson().fromJson(url,
                        new TypeToken<List<String>>() {
                        }.getType());
                break;

            default:
                break;
        }
        // 根据图片的路径显示我们
        if (result.contains(",")) {

            fragment.splits = result.split(",");

            fragment.badge3.setText("" + fragment.splits.length);
            fragment.badge3.show();

            bitmapUtils.display(imageView, Constants.GETIMGURL + fragment.splits[0]);

        } else {

            fragment. badge3.setText("1");
            fragment. badge3.show();
            bitmapUtils.display(imageView, Constants.GETIMGURL + result);
        }
    }

    public void showImageTwo(List<String> list, ImageView imageView, int flag) {
        // System.out.println("flag....." + flag + "...list.size()" +
        // list.size());
        switch (flag) {
            case 1:
                if (fragment.badgeSfzzm == null) {
                    fragment.badgeSfzzm = new BadgeView(fragment.getActivity(), imageView);
                    imageView.setTag(fragment.badgeSfzzm);
                } else {
                    fragment.badgeSfzzm = (BadgeView) imageView.getTag();
                }
                fragment. badge3 = fragment.badgeSfzzm;

                break;
            case 2:
                if (fragment.badgesfzfm == null) {
                    fragment.badgesfzfm = new BadgeView(fragment.getActivity(), imageView);
                    imageView.setTag(fragment.badgesfzfm);
                } else {
                    fragment.badgesfzfm = (BadgeView) imageView.getTag();
                }
                fragment.badge3 = fragment.badgesfzfm;

                break;
            case 3:
                if (fragment.badgescsfzm == null) {

                    fragment. badgescsfzm = new BadgeView(fragment.getActivity(), imageView);
                    imageView.setTag(fragment.badgescsfzm);

                } else {
                    fragment.badgescsfzm = (BadgeView) imageView.getTag();
                }
                fragment.badge3 = fragment.badgescsfzm;

                break;
            case 4:
                if (fragment.badgeydcyhy == null) {

                    fragment. badgeydcyhy = new BadgeView(fragment.getActivity(), imageView);
                    imageView.setTag(fragment.badgeydcyhy);
                } else {
                    fragment. badgeydcyhy = (BadgeView) imageView.getTag();
                }
                fragment.badge3 = fragment.badgeydcyhy;

                break;
            case 5:
                if (fragment.badgezzzm == null) {

                    fragment. badgezzzm = new BadgeView(fragment.getActivity(), imageView);
                    imageView.setTag(fragment.badgezzzm);
                } else {

                    fragment.badgezzzm = (BadgeView) imageView.getTag();
                }
                fragment.badge3 = fragment.badgezzzm;

                break;
            case 6:
                if (fragment.badgesqrxq == null) {

                    fragment.badgesqrxq = new BadgeView(fragment.getActivity(), imageView);
                    imageView.setTag(fragment.badgesqrxq);
                } else {

                    fragment.badgesqrxq = (BadgeView) imageView.getTag();
                }
                fragment. badge3 =fragment. badgesqrxq;

                break;
            case 7:

                if (fragment.badgesqrszl == null) {

                    fragment. badgesqrszl = new BadgeView(fragment.getActivity(), imageView);
                    imageView.setTag(fragment.badgesqrszl);
                } else {

                    fragment.badgesqrszl = (BadgeView) imageView.getTag();
                }
                fragment. badge3 =fragment. badgesqrszl;

                break;
            case 8:
                if (fragment.badgesqrszdy == null) {

                    fragment.badgesqrszdy = new BadgeView(fragment.getActivity(), imageView);
                    imageView.setTag(fragment.badgesqrszdy);
                } else {

                    fragment.badgesqrszdy = (BadgeView) imageView.getTag();
                }
                fragment.badge3 = fragment.badgesqrszdy;

                break;
            case 9:

                if (fragment.badgesqrszmph == null) {

                    fragment.badgesqrszmph = new BadgeView(fragment.getActivity(), imageView);
                    imageView.setTag(fragment.badgesqrszmph);
                } else {

                    fragment.badgesqrszmph = (BadgeView) imageView.getTag();
                }
                fragment. badge3 = fragment.badgesqrszmph;

                break;
            case 10:
                if (fragment.badgedw == null) {

                    fragment.badgedw = new BadgeView(fragment.getActivity(), imageView);
                    imageView.setTag(fragment.badgedw);
                } else {

                    fragment. badgedw = (BadgeView) imageView.getTag();
                }
                fragment. badge3 = fragment.badgedw;

                break;

            default:
                break;
        }

        if (list.size() > 0) {
            fragment.badge3.setText(list.size() + "");
            fragment.badge3.show();
        }

    }









}
