package network.platon.contracts.wasm;

import com.platon.rlp.datatypes.Uint8;
import java.math.BigInteger;
import java.util.Arrays;
import org.web3j.abi.WasmFunctionEncoder;
import org.web3j.abi.datatypes.WasmFunction;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
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
 * <p>Generated with platon-web3j version 0.9.1.2-SNAPSHOT.
 */
public class ContractReceiverNoRet extends WasmContract {
    private static String BINARY_0 = "0x0061736d0100000001480d60017f0060017f017f60027f7f0060037f7f7f017f60000060027f7f017f60047f7f7f7f0060047f7f7f7f017f60037f7f7f0060027f7e006000017f60027f7e017f60017f017e02a9010703656e760c706c61746f6e5f70616e6963000403656e7617706c61746f6e5f6765745f696e7075745f6c656e677468000a03656e7610706c61746f6e5f6765745f696e707574000003656e7617706c61746f6e5f6765745f73746174655f6c656e677468000503656e7610706c61746f6e5f6765745f7374617465000703656e7610706c61746f6e5f7365745f7374617465000603656e760d706c61746f6e5f72657475726e00020342410404000000030605010000040103080001020c00010101050002020004070109030205010301020b020209050305010301020307000308010404010106000202020405017001050505030100020608017f0141d08a040b073904066d656d6f72790200115f5f7761736d5f63616c6c5f63746f727300070f5f5f66756e63735f6f6e5f65786974002306696e766f6b650012090a010041010b0409090b090ae3584108001008103f10400b3801017f4194084200370200419c08410036020041742100034020000440200041a0086a4100360200200041046a21000c010b0b4101100a0b0300010b940101027f41a008410136020041a408280200220145044041a40841ac0836020041ac0821010b024041a8082802002202412046044041840210132201450d012001103e220141a40828020036020041a408200136020041a8084100360200410021020b41a808200241016a360200200120024102746a22014184016a4100360200200141046a20003602000b41a00841003602000b7901047f230041106b22022400200041186a2103410021000340200041ff0171410249044020032002410c6a2000100c220428020022014504404110100f220120003a000d2001410e6a41003a00002003200228020c20042001100d0b2001410e6a20003a0000200041016a21000c010b0b200241106a24000b8e0101027f200041046a21030240200028020422000440200241ff01712104024003400240024020002d000d220220044b0440200028020022020d012001200036020020000f0b200220044f0d03200041046a210320002802042202450d01200321000b20002103200221000c010b0b2001200036020020030f0b200120003602000c010b200120033602000b20030ba40201027f20032001360208200342003702002002200336020020002802002802002201044020002001360200200228020021030b2003200320002802042205463a000c03400240024020032005460d00200328020822012d000c0d002001200128020822022802002204460440024020022802042204450d0020042d000c0d000c030b20032001280200470440200110102001280208220128020821020b200141013a000c200241003a000c200210110c010b02402004450d0020042d000c0d000c020b20032001280200460440200110112001280208220128020821020b200141013a000c200241003a000c200210100b2000200028020841016a3602080f0b2004410c6a200141013a000c200220022005463a000c41013a0000200221030c000b000b6501047f2000411c6a22042105200421020340200528020022030440200341046a200320032d000d20014922001b21052002200320001b21020c010b0b41002100024020022004460d0020022d000d20014b0d002002410e6a2d000021000b200041ff01710b0b002000410120001b10130b5101027f200020002802042201280200220236020420020440200220003602080b200120002802083602082000280208220220022802002000474102746a200136020020002001360208200120003602000b5101027f200020002802002201280204220236020020020440200220003602080b200120002802083602082000280208220220022802002000474102746a200136020020002001360208200120003602040b9a0302067f017e23004180016b22002400100710012201101322021002200041206a200041086a200220011014220341001015200041206a101602400240200041206a1017450d002000280224450d0020002802202d000041c001490d010b10000b200041e0006a200041206a10182000280264220141094f044010000b200028026021020340200104402001417f6a210120023100002006420886842106200241016a21020c010b0b024002402006500d00418008101920065104404102101a0c020b418508101920065104404103101a0c020b418a0810192006520d00200041206a200341011015200041206a101b2101200041206a101c200041206a2001100e2102200041c8006a101d2101200041f8006a4100360200200041f0006a4200370300200041e8006a420037030020004200370360200041e0006a2002101e2000280260210541046a101f200120051020200120021021200128020c200141106a28020047044010000b200128020020012802041006200128020c22020440200120023602100b10220c010b10000b102320004180016a24000b970101047f230041106b220124002001200036020c2000047f41c40a200041086a2202411076220041c40a2802006a220336020041c00a200241c00a28020022026a41076a417871220436020002400240200341107420044d044041c40a200341016a360200200041016a21000c010b2000450d010b200040000d0010000b20022001410c6a4104103341086a0541000b200141106a24000b0c00200020012002411c10240bc90202077f017e230041106b220324002001280208220520024b0440200341086a2001102820012003280208200328020c102936020c200320011028410021052001027f410020032802002206450d001a410020032802042208200128020c2207490d001a200820072007417f461b210420060b360210200141146a2004360200200141003602080b200141106a210903402001280214210402402005200249044020040d01410021040b200020092802002004411410241a200341106a24000f0b20032001102841002104027f410020032802002207450d001a410020032802042208200128020c2206490d001a200820066b2104200620076a0b21052001200436021420012005360210200320094100200520041029104320012003290300220a3702102001200128020c200a422088a76a36020c2001200128020841016a22053602080c000b000b4101017f200028020445044010000b0240200028020022012d0000418101470d00200028020441014d047f100020002802000520010b2c00014100480d0010000b0b980101037f200028020445044041000f0b20001016200028020022022c0000220141004e044020014100470f0b027f4101200141807f460d001a200141ff0171220341b7014d0440200028020441014d047f100020002802000520020b2d00014100470f0b4100200341bf014b0d001a2000280204200141ff017141ca7e6a22014d047f100020002802000520020b20016a2d00004100470b0bd40101047f200110252204200128020422024b04401000200128020421020b200128020021052000027f02400240200204404100210120052c00002203417f4a0d01027f200341ff0171220141bf014d04404100200341ff017141b801490d011a200141c97e6a0c010b4100200341ff017141f801490d001a200141897e6a0b41016a21010c010b4101210120050d000c010b410021032002200149200120046a20024b720d00410020022004490d011a200120056a2103200220016b20042004417f461b0c010b41000b360204200020033602000b3901027e42a5c688a1c89ca7f94b210103402000300000220250450440200041016a2100200142b383808080207e20028521010c010b0b20010b2701027f230041306b22012400200141086a101c200141086a20001100001022200141306a24000b7d01037f230041106b22012400200010160240024020001017450d002000280204450d0020002802002d000041c001490d010b10000b200141086a20001018200128020c220041024f044010000b200128020821020340200004402000417f6a210020022d00002103200241016a21020c010b0b200141106a240020030ba508010d7f23004180016b2204240020004200370204200042d5b4cdc68984ddc90d3703102000411c6a220d42003702002000200041046a220b3602002000200d360218200441186a101d220720002903101026200728020c200741106a28020047044010000b200041186a210802400240200728020022032007280204220110032209450d002009100f21050340200220056a41003a00002009200241016a2202470d000b20032001200520021004417f460d0002402004200541016a200220056a2005417f736a10142201280204450d0020012802002d000041c001490d00200441d8006a2001410110272106200441c8006a200141001027210a200628020421020340200a280204200246410020062802082201200a280208461b0d03200441306a20022001411c1024210c0240024002402004280234044020042802302d000041bf014b0d010b10002004280234450d010b20042802302d000041c001490d00200441e8006a200c102841022103200428026c2102034020020440200441002004280268220120012002102922056a20014520022005497222011b3602684100200220056b20011b21022003417f6a21030c010b0b2003450d010b10000b200441e8006a200c41001015200441e8006a101b2105200441e8006a200c41011015200441e8006a101b21032008200441e8006a2005100c22012802004504404110100f220220053a000d2002410e6a20033a00002008200428026820012002100d0b20062006280204220120062802086a410020011b22023602042006280200220104402006200136020820022001102921052006027f200628020422024504404100210141000c010b410021014100200628020822032005490d001a200320052005417f461b210120020b2202ad2001ad42208684370204200641002006280200220320016b2201200120034b1b36020005200641003602080b0c000b000b10000c010b410021090b200728020c22010440200720013602100b024020090d002000280200210202402000280220450d00200028021821032000200d36021820004100360220200028021c2000410036021c410036020820032802042201200320011b2103034020032201450d012002200b470440200120022d000d3a000d2001410e6a2002410e6a2d00003a00002001410d6a210a024020012802082203450440410021030c010b2001200328020022054604402003410036020020032802042205450d012005102a21030c010b200341003602042005450d002005102a21030b2008200441e8006a200a102b21052008200428026820052001100d2002102c21020c010b0b0340200128020822010d000b200b21020b03402002200b460d014110100f220320022f000d3b000d2008200441e8006a2003410d6a102b21012008200428026820012003100d2002102c21020c000b000b20044180016a240020000b2900200041003602082000420037020020004100102d200041146a41003602002000420037020c20000b090020002001ad102e0bea0101047f230041106b22042400200028020422012000280210220341087641fcffff07716a2102027f410020012000280208460d001a2002280200200341ff07714102746a0b2101200441086a2000102f200428020c210303400240200120034604402000410036021420002802082102200028020421010340200220016b41027522034103490d022000200141046a22013602040c000b000b200141046a220120022802006b418020470d0120022802042101200241046a21020c010b0b2003417f6a220241014d04402000418004418008200241016b1b3602100b200020011030200441106a24000b13002000280208200149044020002001102d0b0b090020002001ad10310bc40401097f230041d0006b22032400200341186a101d2104200341c8006a22024100360200200341406b22054200370300200341386a2206420037030020034200370330200341306a2000290310102e2003280230210741046a101f200420071020200420002903101026200428020c200441106a28020047044010000b2004280204210720042802002003101d210120024100360200200542003703002006420037030020034200370330027f200041206a2802004504402003410136023041010c010b2000411c6a2108200341306a41001032210520002802182102037f2002200846047f2005410110321a20032802300520022f000d2106200541001032200641ff0171101e2006410876101e410110321a2002102c21020c010b0b0b2105200341306a410472101f4101100f220241fe013a0000200128020c200141106a28020047044010000b2001280204220641016a220820012802084b047f20012008102d20012802040520060b20012802006a2002410110331a2001200128020441016a3602042001200241016a200520026b6a102020012000280220103421052000411c6a210620002802182102034020022006470440200541021034220020022d000d102120002002410e6a2d000010212002102c21020c010b0b0240200128020c2001280210460440200128020021020c010b100020012802002102200128020c2001280210460d0010000b2007200220012802041005200128020c22000440200120003602100b200428020c22000440200420003602100b200341d0006a24000b880101037f41a008410136020041a4082802002100034020000440034041a80841a8082802002201417f6a2202360200200141014845044041a0084100360200200020024102746a22004184016a280200200041046a28020011000041a008410136020041a40828020021000c010b0b41a808412036020041a408200028020022003602000c010b0b0b730020004200370210200042ffffffff0f370208200020023602042000200136020002402003410871450d002000104120024f0d002003410471044010000c010b200042003702000b02402003411071450d002000104120024d0d0020034104710440100020000f0b200042003702000b20000bff0201037f200028020445044041000f0b2000101641012102024020002802002c00002201417f4a0d00200141ff0171220341b7014d0440200341807f6a0f0b02400240200141ff0171220141bf014d0440024020002802042201200341c97e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241b7012101034020012003460440200241384f0d030c0405200028020020016a41ca7e6a2d00002002410874722102200141016a21010c010b000b000b200141f7014d0440200341c07e6a0f0b024020002802042201200341897e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241f701210103402001200346044020024138490d0305200028020020016a418a7e6a2d00002002410874722102200141016a21010c010b0b0b200241ff7d490d010b10000b20020b08002000200110310be70101037f230041106b2204240020004200370200200041086a410036020020012802042103024002402002450440200321020c010b410021022003450d002003210220012802002d000041c001490d00200441086a2001102820004100200428020c2201200428020822022001102922032003417f461b20024520012003497222031b220536020820004100200220031b3602042000200120056b3602000c010b20012802002103200128020421012000410036020020004100200220016b20034520022001497222021b36020820004100200120036a20021b3602040b200441106a240020000b2101017f20011025220220012802044b044010000b2000200120011042200210430b2301017f230041206b22022400200241086a20002001411410241041200241206a24000b1d01017f03402000220128020022000d00200128020422000d000b20010b6201017f024020002802042203044020022d0000210203400240200220032d000d49044020032802002200450d040c010b200328020422000d0020012003360200200341046a0f0b200021030c000b000b200041046a21030b2001200336020020030b3601017f024020002802042201044003402001220028020022010d000c020b000b0340200020002802082200280200470d000b0b20000b2f01017f2000280208200149044020011013200028020020002802041033210220002001360208200020023602000b0b8b0102027f017e4101210320014280015a0440034020012004845045044020044238862001420888842101200241016a2102200442088821040c010b0b200241384f047f2002103520026a0520020b41016a21030b027f200041186a28020022020440200041086a280200200041146a280200200210360c010b20000b2202200228020020036a36020020000b4f01037f20012802042203200128021020012802146a220441087641fcffff07716a21022000027f410020032001280208460d001a2002280200200441ff07714102746a0b360204200020023602000b2501017f200028020821020340200120024645044020002002417c6a22023602080c010b0b0bb80202037f037e02402001500440200041800110470c010b20014280015a044020012105034020052006845045044020064238862005420888842105200241016a2102200642088821060c010b0b0240200241384f04402002210303402003044020034108762103200441016a21040c010b0b200441c9004f044010000b2000200441b77f6a41ff017110472000200028020420046a1045200028020420002802006a417f6a21042002210303402003450d02200420033a0000200341087621032004417f6a21040c000b000b200020024180017341ff017110470b2000200028020420026a1045200028020420002802006a417f6a210203402001200784500d02200220013c0000200742388620014208888421012002417f6a2102200742088821070c000b000b20002001a741ff017110470b200010440bbf0c02077f027e230041306b22052400200041046a2107027f20014101460440200041086a280200200041146a280200200041186a220228020022041036280200210120022004417f6a360200200710374180104f044020072000410c6a280200417c6a10300b200141384f047f2001103520016a0520010b41016a2101200041186a28020022020440200041086a280200200041146a280200200210360c020b20000c010b0240200710370d00200041146a28020022014180084f0440200020014180786a360214200041086a2201280200220228020021042001200241046a360200200520043602182007200541186a10380c010b2000410c6a2802002202200041086a2802006b4102752204200041106a2203280200220620002802046b2201410275490440418020100f2104200220064704400240200028020c220120002802102206470d0020002802082202200028020422034b04402000200220012002200220036b41027541016a417e6d41027422036a1039220136020c2000200028020820036a3602080c010b200541186a200620036b2201410175410120011b22012001410276200041106a103a2102200028020c210320002802082101034020012003470440200228020820012802003602002002200228020841046a360208200141046a21010c010b0b200029020421092000200229020037020420022009370200200029020c21092000200229020837020c200220093702082002103b200028020c21010b200120043602002000200028020c41046a36020c0c020b02402000280208220120002802042206470d00200028020c2202200028021022034904402000200120022002200320026b41027541016a41026d41027422036a103c22013602082000200028020c20036a36020c0c010b200541186a200320066b2201410175410120011b2201200141036a410276200041106a103a2102200028020c210320002802082101034020012003470440200228020820012802003602002002200228020841046a360208200141046a21010c010b0b200029020421092000200229020037020420022009370200200029020c21092000200229020837020c200220093702082002103b200028020821010b2001417c6a2004360200200020002802082201417c6a22023602082002280200210220002001360208200520023602182007200541186a10380c010b20052001410175410120011b20042003103a2102418020100f2106024020022802082201200228020c2208470d0020022802042204200228020022034b04402002200420012004200420036b41027541016a417e6d41027422036a103922013602082002200228020420036a3602040c010b200541186a200820036b2201410175410120011b22012001410276200241106a280200103a21042002280208210320022802042101034020012003470440200428020820012802003602002004200428020841046a360208200141046a21010c010b0b2002290200210920022004290200370200200420093702002002290208210920022004290208370208200420093702082004103b200228020821010b200120063602002002200228020841046a360208200028020c2104034020002802082004460440200028020421012000200228020036020420022001360200200228020421012002200436020420002001360208200029020c21092000200229020837020c200220093702082002103b052004417c6a210402402002280204220120022802002208470d0020022802082203200228020c22064904402002200120032003200620036b41027541016a41026d41027422066a103c22013602042002200228020820066a3602080c010b200541186a200620086b2201410175410120011b2201200141036a4102762002280210103a2002280208210620022802042101034020012006470440200528022020012802003602002005200528022041046a360220200141046a21010c010b0b20022902002109200220052903183702002002290208210a20022005290320370208200520093703182005200a370320103b200228020421010b2001417c6a200428020036020020022002280204417c6a3602040c010b0b0b200541186a2007102f200528021c410036020041012101200041186a0b2202200228020020016a360200200541306a240020000bf80801067f0340200020046a2105200120046a220341037145200220044672450440200520032d00003a0000200441016a21040c010b0b200220046b210602402005410371220845044003402006411049450440200020046a2202200120046a2203290200370200200241086a200341086a290200370200200441106a2104200641706a21060c010b0b027f2006410871450440200120046a2103200020046a0c010b200020046a2202200120046a2201290200370200200141086a2103200241086a0b21042006410471044020042003280200360200200341046a2103200441046a21040b20064102710440200420032f00003b0000200341026a2103200441026a21040b2006410171450d01200420032d00003a000020000f0b024020064120490d002008417f6a220841024b0d00024002400240024002400240200841016b0e020102000b2005200120046a220628020022033a0000200541016a200641016a2f00003b0000200041036a2108200220046b417d6a2106034020064111490d03200420086a2202200120046a220541046a2802002207410874200341187672360200200241046a200541086a2802002203410874200741187672360200200241086a2005410c6a28020022074108742003411876723602002002410c6a200541106a2802002203410874200741187672360200200441106a2104200641706a21060c000b000b2005200120046a220628020022033a0000200541016a200641016a2d00003a0000200041026a2108200220046b417e6a2106034020064112490d03200420086a2202200120046a220541046a2802002207411074200341107672360200200241046a200541086a2802002203411074200741107672360200200241086a2005410c6a28020022074110742003411076723602002002410c6a200541106a2802002203411074200741107672360200200441106a2104200641706a21060c000b000b2005200120046a28020022033a0000200041016a21082004417f7320026a2106034020064113490d03200420086a2202200120046a220541046a2802002207411874200341087672360200200241046a200541086a2802002203411874200741087672360200200241086a2005410c6a28020022074118742003410876723602002002410c6a200541106a2802002203411874200741087672360200200441106a2104200641706a21060c000b000b200120046a41036a2103200020046a41036a21050c020b200120046a41026a2103200020046a41026a21050c010b200120046a41016a2103200020046a41016a21050b20064110710440200520032d00003a00002005200328000136000120052003290005370005200520032f000d3b000d200520032d000f3a000f200541106a2105200341106a21030b2006410871044020052003290000370000200541086a2105200341086a21030b2006410471044020052003280000360000200541046a2105200341046a21030b20064102710440200520032f00003b0000200541026a2105200341026a21030b2006410171450d00200520032d00003a00000b20000b960201057f2001044020002802042104200041106a2802002202200041146a280200220349044020022001ad2004ad422086843702002000200028021041086a36021020000f0b027f41002002200028020c22026b410375220541016a2206200320026b2202410275220320032006491b41ffffffff01200241037541ffffffff00491b2203450d001a2003410374100f0b2102200220054103746a22052001ad2004ad4220868437020020052000280210200028020c22066b22016b2104200141014e044020042006200110331a0b2000200220034103746a3602142000200541086a3602102000200436020c20000f0b200041c0011047200041001046200028020020002802046a4100410010331a2000104420000b1e01017f03402000044020004108762100200141016a21010c010b0b20010b25002000200120026a417f6a220141087641fcffff07716a280200200141ff07714102746a0b2801017f200028020820002802046b2201410874417f6a410020011b200028021420002802106a6b0ba10202057f017e230041206b22052400024020002802082202200028020c2206470d0020002802042203200028020022044b04402000200320022003200320046b41027541016a417e6d41027422046a103922023602082000200028020420046a3602040c010b200541086a200620046b2202410175410120021b220220024102762000410c6a103a2103200028020821042000280204210203402002200446450440200328020820022802003602002003200328020841046a360208200241046a21020c010b0b2000290200210720002003290200370200200320073702002000290208210720002003290208370208200320073702082003103b200028020821020b200220012802003602002000200028020841046a360208200541206a24000b2501017f200120006b2201410275210320010440200220002001103d0b200220034102746a0b4f01017f2000410036020c200041106a2003360200200104402001410274100f21040b200020043602002000200420024102746a22023602082000200420014102746a36020c2000200236020420000b2b01027f200028020821012000280204210203402001200247044020002001417c6a22013602080c010b0b0b1b00200120006b22010440200220016b220220002001103d0b20020b8d0301037f024020002001460d00200120006b20026b410020024101746b4d044020002001200210331a0c010b20002001734103712103027f024020002001490440200020030d021a410021030340200120036a2104200020036a2205410371450440200220036b210241002103034020024104490d04200320056a200320046a280200360200200341046a21032002417c6a21020c000b000b20022003460d04200520042d00003a0000200341016a21030c000b000b024020030d002001417f6a21030340200020026a22044103714504402001417c6a21032000417c6a2104034020024104490d03200220046a200220036a2802003602002002417c6a21020c000b000b2002450d042004417f6a200220036a2d00003a00002002417f6a21020c000b000b2001417f6a210103402002450d03200020026a417f6a200120026a2d00003a00002002417f6a21020c000b000b200320046a2101200320056a0b210303402002450d01200320012d00003a00002002417f6a2102200341016a2103200141016a21010c000b000b0bc90201037f200041003a000020004184026a2201417f6a41003a0000200041003a0002200041003a00012001417d6a41003a00002001417e6a41003a0000200041003a00032001417c6a41003a00002000410020006b41037122026a22014100360200200141840220026b417c7122036a2202417c6a4100360200024020034109490d002001410036020820014100360204200241786a4100360200200241746a410036020020034119490d002001410036021820014100360214200141003602102001410036020c200241706a41003602002002416c6a4100360200200241686a4100360200200241646a41003602002003200141047141187222036b2102200120036a2101034020024120490d0120014200370300200141186a4200370300200141106a4200370300200141086a4200370300200141206a2101200241606a21020c000b000b20000b3501017f230041106b220041d08a0436020c41bc0a200028020c41076a417871220036020041c00a200036020041c40a3f003602000b3801017f41b00a420037020041b80a410036020041742100034020000440200041bc0a6a4100360200200041046a21000c010b0b4104100a0b2e01017f200028020445044041000f0b4101210120002802002c0000417f4c047f20001042200010256a0541010b0b5b00027f027f41002000280204450d001a410020002802002c0000417f4a0d011a20002802002d0000220041bf014d04404100200041b801490d011a200041c97e6a0c010b4100200041f801490d001a200041897e6a0b41016a0b0b5a01027f2000027f0240200128020022054504400c010b200220036a200128020422014b2001200249720d00410020012003490d011a200220056a2104200120026b20032003417f461b0c010b41000b360204200020043602000bf50101057f0340024020002802102201200028020c460d00200141786a2802004504401000200028021021010b200141786a22022002280200417f6a220436020020040d002000200236021020004101200028020422032001417c6a28020022026b22011035220441016a20014138491b220520036a1045200220002802006a220320056a20032001103d200141374d0440200028020020026a200141406a3a00000c020b200441f7016a220341ff014d0440200028020020026a20033a00002000280200200220046a6a210203402001450d03200220013a0000200141087621012002417f6a21020c000b000510000c020b000b0b0b0f0020002001102d200020013602040b1b00200028020420016a220120002802084b044020002001102d0b0b2500200041011046200028020020002802046a20013a00002000200028020441016a3602040b0b1a01004180080b13696e697400696e666f006765745f76616c7565";

    public static String BINARY = BINARY_0;

    public static final String FUNC_GET_VALUE = "get_value";

    public static final String FUNC_INFO = "info";

    protected ContractReceiverNoRet(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    protected ContractReceiverNoRet(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<Uint8> get_value(Uint8 key) {
        final WasmFunction function = new WasmFunction(FUNC_GET_VALUE, Arrays.asList(key), Uint8.class);
        return executeRemoteCall(function, Uint8.class);
    }

    public static RemoteCall<ContractReceiverNoRet> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(ContractReceiverNoRet.class, web3j, credentials, contractGasProvider, encodedConstructor);
    }

    public static RemoteCall<ContractReceiverNoRet> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(ContractReceiverNoRet.class, web3j, transactionManager, contractGasProvider, encodedConstructor);
    }

    public static RemoteCall<ContractReceiverNoRet> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, BigInteger initialVonValue) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(ContractReceiverNoRet.class, web3j, credentials, contractGasProvider, encodedConstructor, initialVonValue);
    }

    public static RemoteCall<ContractReceiverNoRet> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, BigInteger initialVonValue) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(ContractReceiverNoRet.class, web3j, transactionManager, contractGasProvider, encodedConstructor, initialVonValue);
    }

    public RemoteCall<TransactionReceipt> info() {
        final WasmFunction function = new WasmFunction(FUNC_INFO, Arrays.asList(), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> info(BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_INFO, Arrays.asList(), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public static ContractReceiverNoRet load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return new ContractReceiverNoRet(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ContractReceiverNoRet load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return new ContractReceiverNoRet(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
