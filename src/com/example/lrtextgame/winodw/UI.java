package com.example.lrtextgame.winodw;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class UI extends BasicScrollBarUI {

    @Override
    protected void configureScrollBarColors() {
        // 设置轨道颜色
        trackColor = new Color(70, 70, 70);
        // 设置滑块颜色（背景和阴影）
        thumbColor = new Color(120, 120, 120);
        thumbDarkShadowColor = new Color(70, 70, 70);
        thumbHighlightColor = new Color(120, 120, 120);
        thumbLightShadowColor = new Color(110, 120, 120);
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        // 绘制纯黑色轨道
        g.setColor(new Color(70, 70, 70));
        g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        if (thumbBounds.isEmpty() || !scrollbar.isEnabled()) return;

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 滑块颜色（渐变效果可选）
        Color startColor = new Color(120, 120, 120);
        Color endColor = new Color(120, 120, 120);
        GradientPaint gp = new GradientPaint(thumbBounds.x, thumbBounds.y, startColor,
                thumbBounds.x, thumbBounds.y + thumbBounds.height, endColor);
        g2.setPaint(gp);
        g2.fillRoundRect(thumbBounds.x+5, thumbBounds.y, thumbBounds.width -6, thumbBounds.height, 6, 6);

        // 滑块边缘亮边
        g2.setColor(new Color(140, 140, 140));
        g2.drawRoundRect(thumbBounds.x+5, thumbBounds.y, thumbBounds.width - 7, thumbBounds.height - 1, 6, 6);

        g2.dispose();
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return createZeroButton();
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return createZeroButton();
    }

    private JButton createZeroButton() {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(0, 0));
        button.setMinimumSize(new Dimension(0, 0));
        button.setMaximumSize(new Dimension(0, 0));
        return button;
    }
}