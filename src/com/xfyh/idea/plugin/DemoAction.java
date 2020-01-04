package com.xfyh.idea.plugin;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;

/**
 * @Description: 在edit菜单下增加demo功能，步骤：
 * 1.新建一个Intellij IDEA plugin的项目
 * 2.新建action 并编写api
 *      ActionID:代表该Action的唯一的ID，一般的格式为：pluginName.ID
 *      ClassName:类名
 *      Name:就是最终插件在菜单上的名称
 *      Description:对这个Action的描述信息
 *      选择group:EditMenu
 *  3.点击prepare plugin生成jar，这个jar就可以用来安装了

 * @Auther: xfyh
 * @Date: 2019/12/10 18:04
 */
public class DemoAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        Messages.showMessageDialog("Hello World !", "Information", Messages.getInformationIcon());
    }
}
