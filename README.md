# ThjDialog
简单dialog

gradle 依赖：

	allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
 
 
	dependencies {
	        compile 'com.github.andyxiaoxi:ThjDialog:v1.0.0'
	}
  
  
  
maven 依赖：

	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://www.jitpack.io</url>
		</repository>
	</repositories>
  
 <dependency>
	    <groupId>com.github.andyxiaoxi</groupId>
	    <artifactId>ThjDialog</artifactId>
	    <version>v1.0.0</version>
	</dependency>
  
  
  
  How to use：
  ~~~
       example1:
       CustomDialog dialog = new CustomDialog(this);
        
       dialog.show("提示","这是一条消息");
	
       example2:
       customDialog.show("提示", "提示消息", new CustomDialog.OnComfirmListener() {
            @Override
            public void onClick(CustomDialog customDialog) {
                Log.i("test","确认");
                customDialog.dismiss();
            }
        });
	example3:
	customDialog.show("提示", "提示消息", new CustomDialog.OnComfirmListener() {
            @Override
            public void onClick(CustomDialog customDialog) {
                Log.i("test", "确认");
                customDialog.dismiss();
            }
        }, new CustomDialog.OnCancelListener() {
            @Override
            public void onClick(CustomDialog customDialog) {
                Log.i("test", "取消");
                customDialog.dismiss();
            }
~~~
