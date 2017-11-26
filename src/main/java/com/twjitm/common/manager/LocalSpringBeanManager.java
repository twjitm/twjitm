package com.twjitm.common.manager;

import com.twjitm.common.service.ILocalService;
import com.twjitm.common.service.RPCService;
import com.twjitm.receipt.service.IReceiptService;
import com.twjitm.user.service.IUserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;


/**
 * Created by 文江 on 2017/11/16.
 */
@Service
public class LocalSpringBeanManager implements ILocalService{


    private IReceiptService receiptService;

    private IUserService userService;
    private RPCService rpcService;

    private ClassPathXmlApplicationContext applicationContext;

    public IReceiptService getReceiptService() {
        return receiptService= (IReceiptService) this.applicationContext.getBean("IReceiptService");
    }

    public void setReceiptService(IReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    public IUserService getUserService() {
        return this.userService= (IUserService) this.applicationContext.getBean("IUserService");
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public String getId() {
        return null;
    }

    public void startup() throws Exception {//G:\git\twjitm\src\main\resources\spring\applicationContext.xml
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring/applicationContext-rpc.xml");
        this.applicationContext=applicationContext;
    }

    public RPCService getRpcService() {
        return rpcService;
    }

    public void setRpcService(RPCService rpcService) {
        this.rpcService = rpcService;
    }

    public void shutdown() throws Exception {

    }
}
