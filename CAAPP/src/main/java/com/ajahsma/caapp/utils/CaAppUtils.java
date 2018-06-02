/**
 * 
 */
package com.ajahsma.caapp.utils;

import java.util.List;

import org.springframework.beans.BeanUtils;

/**
 * @author Dev
 *
 */
public class CaAppUtils 
{
	public static <Source, Destination> Destination copyBeanProperties(Source source, Class target)
	{
		Destination destination = null;
		try {
			destination = (Destination) target.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		BeanUtils.copyProperties(source, target);
		return destination;
	}
	
	public static boolean isListNotNullAndEmpty(List list)
	{
		return (list != null && !list.isEmpty());
	}
	
	public static boolean isNotNull(Object object)
	{
		return (null != object);
	}
}
