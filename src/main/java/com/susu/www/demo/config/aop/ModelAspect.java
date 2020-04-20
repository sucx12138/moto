package com.susu.www.demo.config.aop;

import com.susu.www.demo.common.ModelUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author sucx
 * @title: ModelAspect
 * @projectName springboot_demo
 * @description: 数据模型切面
 * @date 2020/1/2211:02
 */
@Aspect
@Component
public class ModelAspect {
    @Pointcut("execution(public * com.susu.www.demo.service.impl..save*(..))")
    public void saveAspect(){ }
    @Pointcut("execution(public * com.susu.www.demo.service.impl..insert*(..))")
    public void insertAspect(){ }
    @Pointcut("execution(public * com.susu.www.demo.service.impl..add*(..))")
    public void addAspect(){ }
    @Pointcut("execution(public * com.susu.www.demo.service.impl..update*(..))")
    public void updateAspect(){ }
    @Pointcut("execution(public * com.susu.www.demo.service.impl..edit*(..))")
    public void editAspect(){ }

    @Before("saveAspect()")
    public void saveBefore(JoinPoint joinPoint){
        setCreateBaseInfo(joinPoint);
    }
    @Before("insertAspect()")
    public void insertBefore(JoinPoint joinPoint){
        setCreateBaseInfo(joinPoint);
    }
    @Before("addAspect()")
    public void addBefore(JoinPoint joinPoint){
        setCreateBaseInfo(joinPoint);
    }

    @Before("updateAspect()")
    public void updateBefore(JoinPoint joinPoint){
        setUpdateBaseInfo(joinPoint);
    }
    @Before("editAspect()()")
    public void editBefore(JoinPoint joinPoint){
        setUpdateBaseInfo(joinPoint);
    }

    /**
     * 更新数据模型基础字段添加
     * @param joinPoint
     */
    private void setUpdateBaseInfo(JoinPoint joinPoint) {
        //获取目标方法的参数信息
        Object[] objs = joinPoint.getArgs();
        if (null == objs){
            return;
        }
        //封装基础数据
        for (Object obj : objs) {
            ModelUtil.setUpdateBaseInfo(obj);
        }
    }

    /**
     * 新增数据模型基础字段添加
     * @param joinPoint
     */
    private void setCreateBaseInfo(JoinPoint joinPoint) {
        //获取目标方法的参数信息
        Object[] objs = joinPoint.getArgs();
        if (null == objs){
            return;
        }
        //封装基础数据
        for (Object obj : objs) {
            ModelUtil.setCreateBaseInfo(Optional.of(obj));
        }
    }


}
