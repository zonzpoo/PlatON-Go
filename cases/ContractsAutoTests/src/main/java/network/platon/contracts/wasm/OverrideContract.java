package network.platon.contracts.wasm;

import com.platon.rlp.datatypes.Uint32;
import com.platon.rlp.datatypes.Uint64;
import java.math.BigInteger;
import java.util.Arrays;
import org.web3j.abi.WasmFunctionEncoder;
import org.web3j.abi.datatypes.WasmFunction;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.WasmContract;
import org.web3j.tx.gas.GasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://github.com/PlatONnetwork/client-sdk-java/releases">platon-web3j command line tools</a>,
 * or the org.web3j.codegen.WasmFunctionWrapperGenerator in the 
 * <a href="https://github.com/PlatONnetwork/client-sdk-java/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with platon-web3j version 0.13.1.5.
 */
public class OverrideContract extends WasmContract {
    private static String BINARY_0 = "0x0061736d01000000014f0e60017f017f60000060027f7f0060017f0060037f7f7f0060017f017e60047f7f7f7f0060037e7e7f006000017f60027f7f017f60037f7f7f017f60047f7f7f7f017f60027f7e017f60027e7e017f02b1010803656e760c706c61746f6e5f70616e6963000103656e760d726c705f6c6973745f73697a65000003656e760f706c61746f6e5f726c705f6c697374000403656e760d726c705f753132385f73697a65000d03656e760f706c61746f6e5f726c705f75313238000703656e7617706c61746f6e5f6765745f696e7075745f6c656e677468000803656e7610706c61746f6e5f6765745f696e707574000303656e760d706c61746f6e5f72657475726e0002031716010c01000b04050500020201030002090a00010000060405017001020205030100020608017f0141c088040b073904066d656d6f72790200115f5f7761736d5f63616c6c5f63746f727300080f5f5f66756e63735f6f6e5f65786974001306696e766f6b65000a0907010041010b01190ab71f160400101a0b2d002001427f7c2201420156044041000f0b2001a741016b0440200020002802002802001100000f0b4190ce000b9b0402077f027e230041406a22002400101a10052201100b22021006200041286a200020022001411c100c22014100100d02400240200041286a100e2207500d00418008100f2007510440200110104101460d020c010b418508100f2007520d0020011010410247044010000b41012102200041286a20014101100d200041286a100e2107200042818080801037021c2000419808360218200041186a20071009210341002101200041003602304200210720004200370328200041286a410010112000413c6a41003602002000420037023420034180014f04402003ad2108034020072008845045044020074238862008420888842108200141016a2101200742088821070c010b0b024020014138490d002001210203402002450d01200141016a2101200241087621020c000b000b200141016a21020b20002802302002490440200041286a200210110b200041286a42002003ad22071003200028022c22016a1012420020072001200028022822046a10040340024020002802382202200028023422054622060d00200241786a220128020022034504401000200128020021030b20012003417f6a220336020020030d0020002001360238200041286a2002417c6a2802002201200028022c20016b220210016a10122001200028022822046a22012002200110020c010b0b200645044010000b2004200028022c10072005450d01200020053602380c010b10000b1013200041406b24000b9b0101047f230041106b220124002001200036020c2000047f41b008200041086a2202411076220041b0082802006a220336020041ac0841ac08280200220420026a41076a417871220236020002400240200341107420024d044041b008200341016a360200200041016a21000c010b2000450d010b200040000d0010000b20042001410c6a4104101841086a0541000b2100200141106a240020000b730020004200370210200042ffffffff0f370208200020023602042000200136020002402003410871450d002000101b20024f0d002003410471044010000c010b200042003702000b02402003411071450d002000101b20024d0d0020034104710440100020000f0b200042003702000b20000bc90202067f017e230041106b220324002001280208220520024b0440200341086a2001101620012003280208200328020c101736020c200320011016410021052001027f410020032802002207450d001a410020032802042208200128020c2206490d001a200820062006417f461b210420070b360210200141146a2004360200200141003602080b200141106a210603402001280214210402402005200249044020040d01410021040b2000200628020020044114100c1a200341106a24000f0b20032001101641002104027f410020032802002205450d001a410020032802042208200128020c2207490d001a200820076b2104200520076a0b21052001200436021420012005360210200320064100200520041017101d2001200329030022093702102001200128020c2009422088a76a36020c2001200128020841016a22053602080c000b000bad0302057f017e20001014024002402000280204450d00200010140240200028020022012c0000220241004e044020020d010c020b200241807f460d00200241ff0171220341b7014d0440200028020441014d04401000200028020021010b20012d00010d010c020b200341bf014b0d012000280204200241ff017141ca7e6a22024d04401000200028020021010b200120026a2d0000450d010b2000280204450d0020012d000041c001490d010b10000b200010152204200028020422014b04401000200028020421010b20002802002105024002400240200104404100210320052c00002200417f4a0d01027f200041ff0171220341bf014d04404100200041ff017141b801490d011a200341c97e6a0c010b4100200041ff017141f801490d001a200341897e6a0b41016a21030c010b4101210320050d00410021000c010b41002100200320046a20014b0d0020012004490d004100210220012003490d01200320056a2102200120036b20042004417f461b22004109490d0110000c010b410021020b0340200004402000417f6a210020023100002006420886842106200241016a21020c010b0b20060b3901027e42a5c688a1c89ca7f94b210103402000300000220250450440200041016a2100200142b383808080207e20028521010c010b0b20010b800101047f230041106b2201240002402000280204450d0020002802002d000041c001490d00200141086a20001016200128020c210003402000450d01200141002001280208220320032000101722046a20034520002004497222031b3602084100200020046b20031b2100200241016a21020c000b000b200141106a240020020b2f01017f200028020820014904402001100b200028020020002802041018210220002001360208200020023602000b0b3601017f200028020820014904402001100b200028020020002802041018210220002001360208200020023602000b200020013602040b880101037f419c08410136020041a0082802002100034020000440034041a40841a4082802002201417f6a22023602002001410148450440419c084100360200200020024102746a22004184016a280200200041046a280200110300419c08410136020041a00828020021000c010b0b41a408412036020041a008200028020022003602000c010b0b0b4101017f200028020445044010000b0240200028020022012d0000418101470d00200028020441014d047f100020002802000520010b2c00014100480d0010000b0bff0201037f200028020445044041000f0b2000101441012102024020002802002c00002201417f4a0d00200141ff0171220341b7014d0440200341807f6a0f0b02400240200141ff0171220141bf014d0440024020002802042201200341c97e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241b7012101034020012003460440200241384f0d030c0405200028020020016a41ca7e6a2d00002002410874722102200141016a21010c010b000b000b200141f7014d0440200341c07e6a0f0b024020002802042201200341897e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241f701210103402001200346044020024138490d0305200028020020016a418a7e6a2d00002002410874722102200141016a21010c010b0b0b200241ff7d490d010b10000b20020b2101017f20011015220220012802044b044010000b200020012001101c2002101d0b2701017f230041206b22022400200241086a200020014114100c101b2100200241206a240020000bfc0801067f03400240200020046a2105200120046a210320022004460d002003410371450d00200520032d00003a0000200441016a21040c010b0b200220046b210602402005410371220745044003402006411049450440200020046a2203200120046a2205290200370200200341086a200541086a290200370200200441106a2104200641706a21060c010b0b027f2006410871450440200120046a2103200020046a0c010b200020046a2205200120046a2204290200370200200441086a2103200541086a0b21042006410471044020042003280200360200200341046a2103200441046a21040b20064102710440200420032f00003b0000200341026a2103200441026a21040b2006410171450d01200420032d00003a000020000f0b024020064120490d002007417f6a220741024b0d00024002400240024002400240200741016b0e020102000b2005200120046a220328020022073a0000200541016a200341016a2f00003b0000200041036a2108200220046b417d6a2106034020064111490d03200420086a2203200120046a220541046a2802002202410874200741187672360200200341046a200541086a2802002207410874200241187672360200200341086a2005410c6a28020022024108742007411876723602002003410c6a200541106a2802002207410874200241187672360200200441106a2104200641706a21060c000b000b2005200120046a220328020022073a0000200541016a200341016a2d00003a0000200041026a2108200220046b417e6a2106034020064112490d03200420086a2203200120046a220541046a2802002202411074200741107672360200200341046a200541086a2802002207411074200241107672360200200341086a2005410c6a28020022024110742007411076723602002003410c6a200541106a2802002207411074200241107672360200200441106a2104200641706a21060c000b000b2005200120046a28020022073a0000200041016a21082004417f7320026a2106034020064113490d03200420086a2203200120046a220541046a2802002202411874200741087672360200200341046a200541086a2802002207411874200241087672360200200341086a2005410c6a28020022024118742007410876723602002003410c6a200541106a2802002207411874200241087672360200200441106a2104200641706a21060c000b000b200120046a41036a2103200020046a41036a21050c020b200120046a41026a2103200020046a41026a21050c010b200120046a41016a2103200020046a41016a21050b20064110710440200520032d00003a00002005200328000136000120052003290005370005200520032f000d3b000d200520032d000f3a000f200541106a2105200341106a21030b2006410871044020052003290000370000200541086a2105200341086a21030b2006410471044020052003280000360000200541046a2105200341046a21030b20064102710440200520032f00003b0000200541026a2105200341026a21030b2006410171450d00200520032d00003a00000b20000b050041e4000b3501017f230041106b220041c0880436020c41a808200028020c41076a417871220036020041ac08200036020041b0083f003602000b2e01017f200028020445044041000f0b4101210120002802002c0000417f4c047f2000101c200010156a0520010b0b5b00027f027f41002000280204450d001a410020002802002c0000417f4a0d011a20002802002d0000220041bf014d04404100200041b801490d011a200041c97e6a0c010b4100200041f801490d001a200041897e6a0b41016a0b0b5b01027f2000027f0240200128020022054504400c010b200220036a200128020422014b0d0020012002490d00410020012003490d011a200220056a2104200120026b20032003417f461b0c010b41000b360204200020043602000b0b1a02004180080b0c696e69740067657441726561004198080b0101";

    public static String BINARY = BINARY_0;

    public static final String FUNC_GETAREA = "getArea";

    protected OverrideContract(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    protected OverrideContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }

    public static RemoteCall<OverrideContract> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(OverrideContract.class, web3j, credentials, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<OverrideContract> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(OverrideContract.class, web3j, transactionManager, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<OverrideContract> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(OverrideContract.class, web3j, credentials, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public static RemoteCall<OverrideContract> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(OverrideContract.class, web3j, transactionManager, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public RemoteCall<Uint32> getArea(Uint64 input) {
        final WasmFunction function = new WasmFunction(FUNC_GETAREA, Arrays.asList(input), Uint32.class);
        return executeRemoteCall(function, Uint32.class);
    }

    public static OverrideContract load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        return new OverrideContract(contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    public static OverrideContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        return new OverrideContract(contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }
}