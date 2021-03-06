/** ** ** ** ** ** ** **** ** ** ** ** ** ** **** ** ** ** ** ** ** **
 *    ProjectName javacommon
 *    File Name   InsertSort.java 
 * ** ** ** ** ** ** ** **** ** ** ** ** ** ** **** ** ** ** ** ** ** **
 *    Copyright (c) 2015 Darlen . All Rights Reserved. 
 *    注意： 本内容仅限于XXX公司内部使用，禁止转发
 * ** ** ** ** ** ** ** **** ** ** ** ** ** ** **** ** ** ** ** ** ** **
 * */
package com.darlen.sortalgorithm;

import org.apache.log4j.Logger;

/**
 * Description.
 * <p>基本思想：在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排
 好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数
 也是排好顺序的。如此反复循环，直到全部排好顺序。
 * </p>
 * Created on  2015-12-29 下午9:38
 * -------------------------------------------------------------------------
 * 版本     修改时间        作者         修改内容 
 * 1.0.0        下午9:38              Darlen              create
 * -------------------------------------------------------------------------
 *
 * @author Darlen liu
 */
public class InsertSort {

    private static Logger logger = Logger.getLogger(InsertSort.class);

    public static void main(String[] args) {
        //int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
        int a[] = {49, 38, 65, 13,97};
        insertSortAlgorithm(a);
        insertSort(a);
    }

    public static void insertSortAlgorithm(int[] a) {
        logger.info("排序前数组：" + ShellSort.arrayToString(a, ","));
        int i; //当前需要插入值的位置，也就是当前最大位置，例如从只有1个数字 ，现在插入一个数字，那么i = 1（因为数组是从0开始，i = 0+1）
        int j; //指向i前一个位置
        int key; //temp : 当前插入的值
        //从数组第二个位置开始遍历
        for (i = 1; i < a.length; i++) {
//            for(j = 1 ; j >= i && a[i] > a[j]; j++){
//                temp = a[j];
//                a[j] = a[i];
//                a[i] = temp;
//            }

            key = a[i];
            j = i - 1;
            logger.info("第" + i + "次遍历,temp = " + key + ",i = "+i+", j = " + j+",  a[j] = "+ a[j]+", a[j] > temp :" +(a[j] > key)+"，数组："+ ShellSort.arrayToString(a, ","));
            for (; j >= 0 && a[j] > key; j--) {
                logger.info("\t\t##交换前的值，j = "+j+", a[j+1] = " +a[j+1] +", a[j] = " +a[j]+"，数组："+ ShellSort.arrayToString(a, ","));
                a[j + 1] = a[j]; //将a[j]值后移，也就是把大值放到后面
               // a[j ] = temp;
                logger.info("\t\t##交换后的值，j = "+j+", a[j+1] = " +a[j+1] +", a[j] = " +a[j]+"，数组："+ ShellSort.arrayToString(a, ","));
            }
            a[j + 1] = key;//将当前值插入
            //logger.info("\t\t##交换后的值，j = "+j+", a[j+1] = " +a[j+1] +"a[j] = " +a[j]);
            logger.info("第" + i + "次遍历后的数组：" + ShellSort.arrayToString(a, ","));
        }
        logger.info("排序后数组：" + ShellSort.arrayToString(a, ","));

    }

    public static void insertSort(int a[]) {
        int length = a.length; //数组长度
        int j;               //当前值的位置
        int i;               //指向j前的位置
        int key;             //当前要进行插入排序的值
        //从数组的第二个位置开始遍历值
        for (j = 1; j < length; j++) {
            key = a[j];
            i = j - 1;
            //a[i]比当前值大时，a[i]后移一位,空出i的位置，好让下一次循环的值后移
            for (; i >= 0 && a[i] > key; i--) {//i前移
                a[i + 1] = a[i]; //将a[i]值后移
            }//跳出循环(找到要插入的中间位置或已遍历到0下标)
            a[i + 1] = key;    //将当前值插入
        }
        logger.info("排序后数组：" + ShellSort.arrayToString(a, ","));
    }
}

/**
 *  参考分析结果
 2015-12-30 00:07:58,363 [INFO] 排序前数组：49,38,65,13,97
 2015-12-30 00:07:58,369 [INFO] 第1次遍历,temp = 38,i = 1, j = 0,  a[j] = 49, a[j] > temp :true，数组：49,38,65,13,97
 2015-12-30 00:07:58,371 [INFO] 		##交换前的值，j = 0, a[j+1] = 38, a[j] = 49，数组：49,38,65,13,97
 2015-12-30 00:07:58,371 [INFO] 		##交换后的值，j = 0, a[j+1] = 49, a[j] = 49，数组：49,49,65,13,97
 2015-12-30 00:07:58,371 [INFO] 第1次遍历后的数组：38,49,65,13,97
 2015-12-30 00:07:58,372 [INFO] 第2次遍历,temp = 65,i = 2, j = 1,  a[j] = 49, a[j] > temp :false，数组：38,49,65,13,97
 2015-12-30 00:07:58,372 [INFO] 第2次遍历后的数组：38,49,65,13,97
 2015-12-30 00:07:58,376 [INFO] 第3次遍历,temp = 13,i = 3, j = 2,  a[j] = 65, a[j] > temp :true，数组：38,49,65,13,97
 2015-12-30 00:07:58,377 [INFO] 		##交换前的值，j = 2, a[j+1] = 13, a[j] = 65，数组：38,49,65,13,97
 2015-12-30 00:07:58,378 [INFO] 		##交换后的值，j = 2, a[j+1] = 65, a[j] = 65，数组：38,49,65,65,97
 2015-12-30 00:07:58,378 [INFO] 		##交换前的值，j = 1, a[j+1] = 65, a[j] = 49，数组：38,49,65,65,97
 2015-12-30 00:07:58,378 [INFO] 		##交换后的值，j = 1, a[j+1] = 49, a[j] = 49，数组：38,49,49,65,97
 2015-12-30 00:07:58,378 [INFO] 		##交换前的值，j = 0, a[j+1] = 49, a[j] = 38，数组：38,49,49,65,97
 2015-12-30 00:07:58,379 [INFO] 		##交换后的值，j = 0, a[j+1] = 38, a[j] = 38，数组：38,38,49,65,97
 2015-12-30 00:07:58,379 [INFO] 第3次遍历后的数组：13,38,49,65,97
 2015-12-30 00:07:58,379 [INFO] 第4次遍历,temp = 97,i = 4, j = 3,  a[j] = 65, a[j] > temp :false，数组：13,38,49,65,97
 2015-12-30 00:07:58,385 [INFO] 第4次遍历后的数组：13,38,49,65,97
 2015-12-30 00:07:58,385 [INFO] 排序后数组：13,38,49,65,97
 2015-12-30 00:07:58,385 [INFO] 排序后数组：13,38,49,65,97
 */
