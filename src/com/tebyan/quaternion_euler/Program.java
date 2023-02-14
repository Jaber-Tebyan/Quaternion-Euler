package com.tebyan.quaternion_euler;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Program {
	public static void main(String[] args) {
		Euler euler=new Euler(0,0,0);
		
		JFrame frame=new JFrame("Quaternion To Euler Demo");
		Dimension sizeDimension=new Dimension(800,400*5/8);
		System.out.println(sizeDimension);
		frame.setSize(sizeDimension);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		JPanel panel=new JPanel();
		JSlider sliderX=new JSlider(JSlider.HORIZONTAL,0,360,0);
		JLabel rollJLabel=new JLabel("roll: "+sliderX.getValue());
		JSlider sliderY=new JSlider(JSlider.HORIZONTAL,0,360,0);
		JLabel pitchJLabel=new JLabel("pitch: "+sliderY.getValue());
		JSlider sliderZ=new JSlider(JSlider.HORIZONTAL,0,360,0);
		JLabel wJLabel=new JLabel("W: ");
		JLabel xJLabel=new JLabel("X: ");
		JLabel yJLabel=new JLabel("Y: ");
		JLabel zJLabel=new JLabel("Z: ");
		JLabel yawJLabel=new JLabel("yaw: "+sliderZ.getValue());
		
		sliderX.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				
				euler.roll=sliderX.getValue();
				sliderX.setValue((int) (euler.roll%360));

				Quaternion quaternion=new Quaternion(euler);
				setQuat(wJLabel, xJLabel, yJLabel, zJLabel, quaternion);
				rollJLabel.setText("roll: "+sliderX.getValue()+"");
				
			}
		});
		sliderY.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {

				euler.pitch=sliderY.getValue();
				sliderY.setValue((int) (euler.pitch%360));
				Quaternion quaternion=new Quaternion(euler);
				setQuat(wJLabel, xJLabel, yJLabel, zJLabel, quaternion);
				pitchJLabel.setText("pitch: "+sliderY.getValue()+"");
				
			}
		});
		sliderZ.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				euler.yaw=sliderZ.getValue();
				sliderZ.setValue((int) (euler.yaw%360));

				Quaternion quaternion=new Quaternion(euler);
				setQuat(wJLabel, xJLabel, yJLabel, zJLabel, quaternion);
				yawJLabel.setText("yaw: "+sliderZ.getValue()+"");
				
			}
		});
		
		
		
		
		
		BoxLayout layout=new BoxLayout(panel, 1);
		panel.setLayout(layout);
		panel.add(sliderX);
		panel.add(rollJLabel);
		panel.add(sliderY);
		panel.add(pitchJLabel);
		panel.add(sliderZ);
		panel.add(yawJLabel);
		frame.setContentPane(panel);
		JPanel panel2=new JPanel();
		wJLabel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		xJLabel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		yJLabel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		zJLabel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		panel2.add(wJLabel);
		panel2.add(xJLabel);
		panel2.add(yJLabel);
		panel2.add(zJLabel);
		panel.add(panel2);
		
		
	}
	static void setQuat(JLabel w,JLabel x,JLabel y,JLabel z,Quaternion q) {
		w.setText("W: "+q.w+"");
		x.setText("X: "+q.x+"");
		y.setText("Y: "+q.y+"");
		z.setText("Z: "+q.z+"");
	}
}
