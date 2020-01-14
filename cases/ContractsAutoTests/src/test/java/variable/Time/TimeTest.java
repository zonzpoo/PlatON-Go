package variable.Time;

import beforetest.ContractPrepareTest;
import network.platon.autotest.junit.annotations.DataSource;
import network.platon.autotest.junit.enums.DataSourceType;
import network.platon.contracts.Time;
import network.platon.utils.DataChangeUtil;
import org.junit.Before;
import org.junit.Test;
import org.web3j.abi.datatypes.Array;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @title 验证时间单位
 * @description:
 * @author: liweic
 * @create: 2020/01/02 19:50
 **/

public class TimeTest extends ContractPrepareTest {

    @Before
    public void before() {
        this.prepare();
    }

    @Test
    @DataSource(type = DataSourceType.EXCEL, file = "test.xls", sheetName = "Sheet1",
            author = "liweic", showName = "function.TimeTest-时间单位测试")
    public void time() {
        try {
            Time time = Time.deploy(web3j, transactionManager, provider).send();

            String contractAddress = time.getContractAddress();
            TransactionReceipt tx = time.getTransactionReceipt().get();
            collector.logStepPass("time deploy successfully.contractAddress:" + contractAddress + ", hash:" + tx.getTransactionHash());

            //验证时间单位及换算
            //时间戳获取
            BigInteger result = time.testimeDiff().send();
            collector.logStepPass("testimeDiff返回值：" + result);
            collector.assertEqual(new BigInteger("0"),result);

            //秒
            BigInteger second = time.tSeconds().send();
            collector.logStepPass("tSeconds返回值：" + second);
            collector.assertEqual(new BigInteger("1"),second);

            //分
            BigInteger minute = time.tMinutes().send();
            collector.logStepPass("tMinutes返回值：" + minute);
            collector.assertEqual(new BigInteger("60"),minute);

            //时
            BigInteger hour = time.tHours().send();
            collector.logStepPass("tHours返回值：" + hour);
            collector.assertEqual(new BigInteger("3600"),hour);

            //周
            BigInteger week = time.tWeeks().send();
            collector.logStepPass("tWeeks返回值：" + week);
            collector.assertEqual(new BigInteger("604800"),week);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

