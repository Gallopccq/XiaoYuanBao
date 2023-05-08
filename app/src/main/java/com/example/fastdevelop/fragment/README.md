## 如何编写商品栏点击逻辑：  
改写fragment/model/GoodsAdapter.java中的onCreateViewHolder内的onClick方法  

现在的代码：
```java
public void onClick(View v) {
                int position = holder.getAbsoluteAdapterPosition();
                Goods goods = mGoodsList.get(position);
                Toast.makeText(v.getContext(),goods.getTitle(),
                        Toast.LENGTH_SHORT).show();
            }
```
改写建议：  
前两行不变，根据获取的goods变量跳转到商品详情界面，界面具体内容由goods变量确定  

tips：
商品栏显示逻辑：  
（代码在HomeFragment.java的initGoodsModule方法内）  

```java
private void initGoodsModule() {
        initGoods(); // 初始化（加载）图标（各个模块）数据
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.module_home_goods);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        GoodsAdapter goodsAdapter = new GoodsAdapter(goodsList);
        recyclerView.setAdapter(goodsAdapter);

    }
```
initGoods方法加载数据  
找到RecycleView  
获取并设置视图管理器  
生成并设置适配器（适配器用于传递数据给view，并有一系列操作）  
  

## 如何改写大类模块点击事件  
因为大类模块直接又home_class_module.xml文件指定，所以直接在HomeFragment.java中编写对应点击事件即可  
另，home_class_module.xml中的id为icon_name1，icon_name2，...，icon_name8，icon_name1，icon_name2，...，icon_name8  
参考修改：  
编写initModuleModule()方法，在其内依次寻找id，根据id设置相应点击事件。考虑到图片id和标题id分离，可以采用图片id或其他方法（如用LinearLayout包装图片和标题，并给layout一个id）


## 编写搜索框代码建议：  
① 搜索框的搜索图标大小是随意调的，能看出来有一点歪斜，这部分ui需要修改  
② 搜索框代码编写上：  
可以为fragment_home.xml的EditText对象添加方法，当编写内容时，自动跳转到搜索框界面  
一种可能的设计：跳转到商品展示界面（此时是空白的），输完内容点击搜索按钮后，填充本界面；点击回退按钮（或直接回退），回到HomeActivity.java  
另一种：跳转到SearchFragment（此时是空白的，可以有历史搜索记录），然后输完内容点击搜索按钮后，跳转到商品展示界面（一个Activity）；点击回退按钮（或直接回退），回到HomeFragment