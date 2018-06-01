package services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.EasyUITree;



import domain.T_SysMenu;


import Mapper.T_SysMenuMapper;

@Service
public class Menuservice {
	
	@Autowired
	private T_SysMenuMapper menuMapper;
	
	private List<T_SysMenu> menuList;
	/**
	 * 根据用户id,获取具有的菜单功能
	 * @param userId
	 * @return
	 */
	private List<T_SysMenu> getMenusByUserId(Integer userId){
		return menuMapper.getMenusByUserId(userId);
	}

	private List<T_SysMenu> findNode(Integer userId,Integer parentId){
		 menuList=getMenusByUserId(userId);
		List<T_SysMenu> resultList=new ArrayList<T_SysMenu>();
		for(T_SysMenu menu:menuList){
			if (menu.getParentId()==parentId){
				resultList.add(menu);
			}
		}
		return resultList;
	}
	/**
	 * 生成Easyui手风琴的滑块以及功能树
	 * 
	 * @param userId
	 * @return
	 */
	public String getModuleString(Integer userId) {
		// 模块
		String accordionFormat = "<div title=\"%s\" data-options=\"iconCls:'%s'\" style=\"overflow: auto; padding: 10px;\">\r\n";
		// 功能树
		String treeFormatString = "<ul class=\"easyui-tree\" data-options=\"url:'%s',method:'get',animate:true\"></ul>\r\n";
		String result = "";
		List<T_SysMenu> menuList = this.findNode(userId, 0);
		for (T_SysMenu userMenu : menuList) {
			result += String.format(accordionFormat, userMenu.getName(), "");
			result += String.format(treeFormatString, "getTree/" + userMenu.getId().toString());
			result += "</div>\r\n";
		}
		return result;
	}
	
	public List<EasyUITree> getTreeNode(Integer userId,Integer parentId) {
		this.menuList=findNode(userId, parentId);
		List<EasyUITree> list = this.getNodeDataByParentId(parentId);
		for (EasyUITree easyUITree : list) {
			// 存在子节点，递归处理
			if (this.isExistsChild(easyUITree.getId()))
				getChildNode(easyUITree);

		}
		return list;
	}
	

	private EasyUITree getChildNode(EasyUITree child) {
		// 叶子节点，跳出
		if (!this.isExistsChild(child.getId())) {
			return child;
		} else {
			List<EasyUITree> childList = this.getNodeDataByParentId(child.getId());
			for (EasyUITree node : childList) {
				child.getChildren().add(getChildNode(node));
			}
			return child;
		}
	}
	/**
	 * 获取节点数据，并转换为EasyUITree
	 * 
	 * @param parentId
	 * @return
	 */
	private List<EasyUITree> getNodeDataByParentId(Integer parentId) {
		String aFormat = "<a rel='tabs' id='%s' title='%s' target='%s' >%s</a>";
		String aElement = "";
		List<EasyUITree> list = new ArrayList<EasyUITree>();

		for (T_SysMenu userMenu : menuList) {
			if (userMenu.getParentId() == parentId) {
				EasyUITree entity = new EasyUITree();
				entity.setId(userMenu.getId());

				if (userMenu.getUrl() == null) {
					entity.setText(userMenu.getName());
				} else {
					aElement = String.format(aFormat, userMenu.getId().toString(), userMenu.getName(),
							userMenu.getUrl(), userMenu.getName());
					entity.setText(aElement);
				}

				list.add(entity);

			}
		}
		return list;
	}

	private Boolean isExistsChild(Integer parentId) {
		Boolean result = false;
		for (T_SysMenu userMenu : menuList) {
			if (userMenu.getParentId() == parentId) {
				result = true;
				break;
			}
		}
		return result;
	}
	
}
