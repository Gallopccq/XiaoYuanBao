添加设置按钮相应事件  
```java
SuperTextView setsuperTextView = (SuperTextView)findViewById(R.id.mine_top);
superTextView.setOnSuperTextViewClickListener(new SuperTextView.OnSuperTextViewClickListener() {
 @Override
 public void onSuperTextViewClick() {
 super.onSuperTextViewClick();
 //do something
 }
 @Override
 public void onLeftTopClick() {s
 super.onLeftTopClick();
 //do something
 }
 @Override
 public void onLeftBottomClick() {
 super.onLeftBottomClick();
 //do something
 }
 @Override
 public void onLeftBottomClick2() {
 super.onLeftBottomClick2();
 //do something
 }
 });
 ```
 注意：点击事件需要配合属性值使用
 ```yaml
 sLeftTopViewIsClickable= true
 sLeftBottomViewIsClickable= true
 sLeftBottomView2IsClickable= true
 ```
