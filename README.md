# image-pro-1.0
Update image processing app.\
New functions - contrast and RGB chart.
## Screenshots
![image](https://user-images.githubusercontent.com/72127610/116143138-0cef7380-a6db-11eb-9fe1-30fbfdb100df.png)
![image](https://user-images.githubusercontent.com/72127610/116143154-124cbe00-a6db-11eb-96f7-013cab92ac9a.png)
### The result of the new RGB chart functionality
![image](https://user-images.githubusercontent.com/72127610/116143173-17aa0880-a6db-11eb-8240-64810f683c94.png)
## Code explanation
### New code in Model
Board class - two new buttons have been added for the Contrast and RGB graph.
```java
...
if(e.equals(pow.powButtons[2])) {
				e.color1 = color_change;
				if (powView.click_p) {
					if(!powModel.picturePathIsEmpty()) {
						questionFormPowModel.frame_contrast();
					}
					powView.click_p = false;
				}
			}
			
if(e.equals(pow.powButtons[3])) {
				e.color1 = color_change;
				if (powView.click_p) {
					if(!powModel.picturePathIsEmpty()) {
						powModel.wykresRgb();
					}
					powView.click_p = false;
				}
			}
...
```
questionFormPowModel class - added new method `frame_contrast()`\
window(InputDialog) for select value of the variable `c`.\
Protection against entering an incorrect value of variable input.\
If value is incorrect, input set 50.\
Invoke the `powModel.contrast(valueOfCon)`
```java
    f = new JFrame();
		String input = "50";
		input = JOptionPane.showInputDialog( "Value of c [-128,127]:");
		if(input == null || input.isEmpty() || !input.matches("^[+-]?([0-9]*[.])?[0-9]+")) {
			input = "50";
			JOptionPane.showMessageDialog(f,"Error input, default input 50");
		}
		valueOfCon = Double.parseDouble(input);
		if(valueOfCon < -128 || valueOfCon > 127) {
			valueOfCon = 50;
			JOptionPane.showMessageDialog(f,"Error input, default input 50");
		}
		powModel.contrast(valueOfCon);
```
powModel class - new method  `contrast(double valueOfCon)`\
By analogy with the first version of image-pro, but with a different implementation of the formula.\
The contrast is obtained by changing the angle of the line on the graph color mapping, option 1.
```java
         ...
         double delta_c = valueOfCon;
				 double x, y, z;
				 x = 0;
				 y = 0;
				 z = 0;
				 
				 if(delta_c <= 127 && delta_c >= 0) {
					 x = (127/(127-delta_c))*(red-delta_c);
					 y = (127/(127-delta_c))*(green-delta_c);
					 z = (127/(127-delta_c))*(blue-delta_c);
				 }
				 
				 if(delta_c >= -128 && delta_c < 0) {
					 x = ((127+delta_c)/127)*red-delta_c;
					 y = ((127+delta_c)/127)*green-delta_c;
					 z = ((127+delta_c)/127)*blue-delta_c;
				 }
         ...
```

