package com.xfyh.idea.plugin;

import com.google.gson.Gson;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.ui.popup.Balloon;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.ui.JBColor;
import com.xfyh.idea.plugin.baidu.TransApi;
import com.xfyh.idea.plugin.baidu.TransResult;
import com.xfyh.idea.plugin.baidu.Translation;
import org.apache.http.util.TextUtils;

import java.awt.*;
import java.util.List;

/**
 * @Description:
 * @Auther: xfyh
 * @Date: 2019/12/11 00:21
 */
public class TranslateAnaction extends AnAction {
    private static final String APP_ID = "";
    private static final String SECURITY_KEY = "";

    /**
     * 1.获得当前选中的单词;
     * 2.调用相关API得到单词的意思
     * 3.通过一个类似于PopupWindow来显示
     * @param e
     */
    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        final Editor mEditor = e.getData(PlatformDataKeys.EDITOR);
        if (null == mEditor) {
            return;
        }
        SelectionModel model = mEditor.getSelectionModel();
        final String selectedText = model.getSelectedText();
        if (TextUtils.isEmpty(selectedText)) {
            return;
        }

        TransApi api = new TransApi(APP_ID, SECURITY_KEY);

        final String transResult = api.getTransResult(selectedText, "auto", "zh");
        System.out.println(transResult);
        final Gson gson = new Gson();
        Translation translation = gson.fromJson(transResult, Translation.class);
        final TransResult transResult1 = translation.getTrans_result().get(0);
        showPopupBalloon(mEditor,transResult1.getSrc()+" : "+ transResult1.getDst());
    }


    private void showPopupBalloon(final Editor editor, final String result) {
        ApplicationManager.getApplication().invokeLater(new Runnable() {
            @Override
            public void run() {
                JBPopupFactory factory = JBPopupFactory.getInstance();
                factory.createHtmlTextBalloonBuilder(result, null, new JBColor(new Color(186, 238, 186), new Color(73, 117, 73)), null)
                        .setFadeoutTime(5000)
                        .createBalloon()
                        .show(factory.guessBestPopupLocation(editor), Balloon.Position.below);
            }
        });
    }
}
