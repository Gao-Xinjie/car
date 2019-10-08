package com.tx652.sys.utils;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeBuilder {
	public static  List<TreeNode> builder(List<TreeNode> nodes, Integer topPid) {
		List<TreeNode> treeNodes= new ArrayList<>();
		for (TreeNode n1 : nodes) {
			if(n1.getPid()==topPid)//如果父节点是1，那么加入到一级菜单中
			{
				treeNodes.add(n1);
			}
			
			for (TreeNode n2 : nodes) 
				if(n2.getPid()==n1.getId()) //在遍历父节点不是1的菜单，如果这下菜单的父节点等于上边id那么加入到他们的子节点里
				{
					n1.getChildren().add(n2);
					
				}
			}
		
		return treeNodes;
	}
}

