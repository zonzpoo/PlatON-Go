package network.platon.contracts.wasm;

import com.platon.rlp.datatypes.Uint32;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.web3j.abi.WasmEventEncoder;
import org.web3j.abi.WasmFunctionEncoder;
import org.web3j.abi.datatypes.WasmEvent;
import org.web3j.abi.datatypes.WasmEventParameter;
import org.web3j.abi.datatypes.WasmFunction;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.PlatonFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.WasmContract;
import org.web3j.tx.gas.GasProvider;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://github.com/PlatONnetwork/client-sdk-java/releases">platon-web3j command line tools</a>,
 * or the org.web3j.codegen.WasmFunctionWrapperGenerator in the 
 * <a href="https://github.com/PlatONnetwork/client-sdk-java/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with platon-web3j version 0.9.1.2-SNAPSHOT.
 */
public class ContractEmitEvent extends WasmContract {
    private static String BINARY_0 = "0x0061736d0100000001480d60027f7f0060017f017f60017f0060037f7f7f0060000060027f7f017f60037f7f7f017f60047f7f7f7f0060047f7f7f7f017f60027f7e006000017f60027f7e017f60017f017e02ce010903656e760c706c61746f6e5f70616e6963000403656e760b706c61746f6e5f73686133000703656e7617706c61746f6e5f6765745f696e7075745f6c656e677468000a03656e7610706c61746f6e5f6765745f696e707574000203656e7617706c61746f6e5f6765745f73746174655f6c656e677468000503656e7610706c61746f6e5f6765745f7374617465000803656e7610706c61746f6e5f7365745f7374617465000703656e760c706c61746f6e5f6576656e74000703656e760d706c61746f6e5f72657475726e0000034e4d0401020202020501000500000105000002050000000003090b0000000303020100010003060100000608020600010301060406030201000c0102000004080109010403040101070500020000000405017001050505030100020608017f0141a08b040b073904066d656d6f72790200115f5f7761736d5f63616c6c5f63746f727300090f5f5f66756e63735f6f6e5f65786974004506696e766f6b65003a090a010041010b040b22240b0ac1614d100041ec08100a1a4101100c104a104c0b190020004200370200200041086a41003602002000100d20000b0300010b940101027f41f808410136020041fc08280200220145044041fc0841840936020041840921010b02404180092802002202412046044041840210382201450d0120011049220141fc0828020036020041fc0820013602004180094100360200410021020b418009200241016a360200200120024102746a22014184016a4100360200200141046a20003602000b41f80841003602000b2201017f03402001410c470440200020016a4100360200200141046a21010c010b0b0bc90201077f23004190016b220124002001419408100f2103200141386a10102102200141286a20031011200220012802282203200128022c101210132002200141286a1014200228020c200241106a28020047044010000b200228020421062002280200200141106a10152104200141d0006a200010162105200141f8006a4100360200200141f0006a4200370300200141e8006a420037030020014200370360200141e0006a41001017200141e0006a20014180016a200510161018200141e0006a4101101720012802602100200141e0006a410472101920042000101320044101101a2200200141e0006a20051016101b200028020c200041106a28020047044010000b2006200028020020002802041007200028020c22040440200020043602100b200304402001200336022c0b200228020c22000440200220003602100b20014190016a24000b910101027f20004200370200200041086a410036020020012102024003402002410371044020022d0000450d02200241016a21020c010b0b2002417c6a21020340200241046a22022802002203417f73200341fffdfb776a7141808182847871450d000b0340200341ff0171450d01200241016a2d00002103200241016a21020c000b000b20002001200220016b102620000b1d0020001027200041146a41003602002000420037020c20004101101a0b870101037f230041306b22032400200341186a101522022001102810132002200341086a20011016101b200228020c200241106a28020047044010000b2000410036020820004200370200200228020421012002280200200041201029200120002802002201200028020420016b1001200228020c22000440200220003602100b200341306a24000b990101027f230041206b22022400200241186a4100360200200241106a4200370300200241086a420037030020024200370300024020002001460440410121030c010b4101210302400240200120006b2201410146044020002c0000417f4c0d010c030b200141374b0d010b200141016a21030c010b2001102a20016a41016a21030b2002200336020020024104721019200241206a240020030b13002000280208200149044020002001102b0b0b1500200020012802002200200128020420006b102c0b190020001027200041146a41003602002000420037020c20000b4d01017f20004200370200200041086a2202410036020020012d0000410171450440200020012902003702002002200141086a28020036020020000f0b200020012802082001280204102620000bbd0c02077f027e230041306b22052400200041046a2107024020014101460440200041086a280200200041146a280200200041186a22022802002204102d280200210120022004417f6a3602002007102e4180104f044020072000410c6a280200417c6a102f0b200141384f047f2001102a20016a0520010b41016a2101200041186a2802002202450d01200041086a280200200041146a2802002002102d21000c010b02402007102e0d00200041146a28020022014180084f0440200020014180786a360214200041086a2201280200220228020021042001200241046a360200200520043602182007200541186a10300c010b2000410c6a2802002202200041086a2802006b4102752204200041106a2203280200220620002802046b220141027549044041802010362104200220064704400240200028020c220120002802102206470d0020002802082202200028020422034b04402000200220012002200220036b41027541016a417e6d41027422036a1031220136020c2000200028020820036a3602080c010b200541186a200620036b2201410175410120011b22012001410276200041106a10322102200028020c210320002802082101034020012003470440200228020820012802003602002002200228020841046a360208200141046a21010c010b0b200029020421092000200229020037020420022009370200200029020c21092000200229020837020c2002200937020820021033200028020c21010b200120043602002000200028020c41046a36020c0c020b02402000280208220120002802042206470d00200028020c2202200028021022034904402000200120022002200320026b41027541016a41026d41027422036a103422013602082000200028020c20036a36020c0c010b200541186a200320066b2201410175410120011b2201200141036a410276200041106a10322102200028020c210320002802082101034020012003470440200228020820012802003602002002200228020841046a360208200141046a21010c010b0b200029020421092000200229020037020420022009370200200029020c21092000200229020837020c2002200937020820021033200028020821010b2001417c6a2004360200200020002802082201417c6a22023602082002280200210220002001360208200520023602182007200541186a10300c010b20052001410175410120011b200420031032210241802010362106024020022802082201200228020c2208470d0020022802042204200228020022034b04402002200420012004200420036b41027541016a417e6d41027422036a103122013602082002200228020420036a3602040c010b200541186a200820036b2201410175410120011b22012001410276200241106a280200103221042002280208210320022802042101034020012003470440200428020820012802003602002004200428020841046a360208200141046a21010c010b0b20022902002109200220042902003702002004200937020020022902082109200220042902083702082004200937020820041033200228020821010b200120063602002002200228020841046a360208200028020c2104034020002802082004460440200028020421012000200228020036020420022001360200200228020421012002200436020420002001360208200029020c21092000200229020837020c2002200937020820021033052004417c6a210402402002280204220120022802002208470d0020022802082203200228020c22064904402002200120032003200620036b41027541016a41026d41027422066a103422013602042002200228020820066a3602080c010b200541186a200620086b2201410175410120011b2201200141036a410276200228021010322002280208210620022802042101034020012006470440200528022020012802003602002005200528022041046a360220200141046a21010c010b0b20022902002109200220052903183702002002290208210a20022005290320370208200520093703182005200a3703201033200228020421010b2001417c6a200428020036020020022002280204417c6a3602040c010b0b0b200541186a20071035200528021c4100360200200041186a2100410121010b2000200028020020016a360200200541306a24000b9a0101037f41012103024002400240200128020420012d00002202410176200241017122041b220241014d0440200241016b0d032001280208200141016a20041b2c0000417f4c0d010c030b200241374b0d010b200241016a21030c010b2002102a20026a41016a21030b200041186a28020022010440200041086a280200200041146a2802002001102d21000b2000200028020020036a3602000bea0101047f230041106b22042400200028020422012000280210220341087641fcffff07716a2102027f410020012000280208460d001a2002280200200341ff07714102746a0b2101200441086a20001035200428020c210303400240200120034604402000410036021420002802082102200028020421010340200220016b41027522034103490d022000200141046a22013602040c000b000b200141046a220120022802006b418020470d0120022802042101200241046a21020c010b0b2003417f6a220241014d04402000418004418008200241016b1b3602100b20002001102f200441106a24000beb0101057f20002802042104200041106a2802002202200041146a280200220349044020022001ad2004ad422086843702002000200028021041086a36021020000f0b027f41002002200028020c22026b410375220541016a2206200320026b2202410275220320032006491b41ffffffff01200241037541ffffffff00491b2203450d001a200341037410360b2102200220054103746a22052001ad2004ad4220868437020020052000280210200028020c22066b22016b2104200141014e044020042006200110391a0b2000200220034103746a3602142000200541086a3602102000200436020c20000b2c01017f20002001280208200141016a20012d0000220041017122021b2001280204200041017620021b102c0bd80201077f23004190016b22022400200241086a418a08100f2104200241406b10102103200241306a200410112003200228023022042002280234101210132003200241306a1014200328020c200341106a28020047044010000b200328020421072003280200200241186a10152105200241d8006a200010162106200241e4006a20011016210120024188016a410036020020024180016a4200370300200241f8006a420037030020024200370370200241f0006a41001017200241f0006a2006101d200241f0006a2001101d200241f0006a4101101720022802702100200241f0006a410472101920052000101320054102101a22002006101e20002001101e200028020c200041106a28020047044010000b2007200028020020002802041007200028020c22010440200020013602100b20040440200220043602340b200328020c22000440200320003602100b20024190016a24000b1e01017f230041106b2202240020002002200110161018200241106a24000b1e01017f230041106b220224002000200220011016101b200241106a24000bf20201067f23004190016b220324002003418008100f2105200341386a10102104200341286a20051011200420032802282205200328022c101210132004200341286a1014200428020c200441106a28020047044010000b200428020421072004280200200341106a10152106200341d0006a200010162100200341dc006a2001101621012003200236026820034188016a410036020020034180016a4200370300200341f8006a420037030020034200370370200341f0006a41001017200341f0006a2000101d200341f0006a2001101d200341f0006a20033502681020200341f0006a4101101720032802702102200341f0006a410472101920062002101320064103101a22022000101e20022001101e200220033502681021220028020c200041106a28020047044010000b2007200028020020002802041007200028020c22010440200020013602100b200504402003200536022c0b200428020c22000440200420003602100b20034190016a24000b840102027f017e4101210320014280015a0440034020012004845045044020044238862001420888842101200241016a2102200442088821040c010b0b200241384f047f2002102a20026a0520020b41016a21030b200041186a28020022020440200041086a280200200041146a2802002002102d21000b2000200028020020036a3602000bba0202037f037e02402001500440200041800110550c010b20014280015a044020012107034020062007845045044020064238862007420888842107200241016a2102200642088821060c010b0b0240200241384f04402002210303402003044020034108762103200441016a21040c010b0b200441c9004f044010000b2000200441b77f6a41ff017110552000200028020420046a1053200028020420002802006a417f6a21042002210303402003450d02200420033a0000200341087621032004417f6a21040c000b000b200020024180017341ff017110550b2000200028020420026a1053200028020420002802006a417f6a210203402001200584500d02200220013c0000200542388620014208888421012002417f6a2102200542088821050c000b000b20002001a741ff017110550b2000105220000b2501017f230041106b22022400200041186a20011023200220011016100e200241106a24000b880201047f20002001470440200128020420012d00002202410176200241017122031b2102200141016a21042001280208410a2101200420031b210420002d0000410171220304402000280200417e71417f6a21010b200220014d0440027f2003044020002802080c010b200041016a0b21012002044020012004200210370b200120026a41003a000020002d00004101710440200020023602040f0b200020024101743a00000f0b416f2103200141e6ffffff074d0440410b20014101742201200220022001491b220141106a4170712001410b491b21030b20031036220120042002104b200020023602042000200341017236020020002001360208200120026a41003a00000b0b2e01017f230041206b22022400200041186a20011023200241106a20011016200220011016101c200241206a24000b3001017f230041206b22032400200041186a20011023200341106a200110162003200110162002101f200341206a24000b5a01027f02402002410a4d0440200020024101743a0000200041016a21030c010b200241106a4170712204103621032000200236020420002004410172360200200020033602080b200320012002104b200220036a41003a00000b1600200041003602082000420037020020004100102b0b5501017f230041306b22012400200141286a4100360200200141206a4200370300200141186a420037030020014200370310200141106a20012000101610182001280210200141106a4104721019200141306a24000bf90101067f024020002802042202200028020022056b220320014904402000280208220720026b200120036b22044f04400340200241003a00002000200028020441016a22023602042004417f6a22040d000c030b000b2001200720056b2202410174220520052001491b41ffffffff07200241ffffffff03491b220104402001103621060b200320066a220321020340200241003a0000200241016a21022004417f6a22040d000b20032000280204200028020022056b22046b2103200441014e044020032005200410391a0b2000200120066a36020820002002360204200020033602000f0b200320014d0d002000200120056a3602040b0b1e01017f03402000044020004108762100200141016a21010c010b0b20010b2f01017f2000280208200149044020011038200028020020002802041039210220002001360208200020023602000b0bdb0101027f4101210302400240024002402002410146044020012c000022024100480d012000200241ff017110550c040b200241374b0d01200221030b200020034180017341ff017110550c010b2002102a220341b7016a22044180024e044010000b2000200441ff017110552000200028020420036a1053200028020420002802006a417f6a210420022103037f2003047f200420033a0000200341087621032004417f6a21040c010520020b0b21030b200020031054200028020020002802046a2001200310391a2000200028020420036a3602040b200010520b25002000200120026a417f6a220141087641fcffff07716a280200200141ff07714102746a0b2801017f200028020820002802046b2201410874417f6a410020011b200028021420002802106a6b0b2501017f200028020821020340200120024645044020002002417c6a22023602080c010b0b0ba10202057f017e230041206b22052400024020002802082202200028020c2206470d0020002802042203200028020022044b04402000200320022003200320046b41027541016a417e6d41027422046a103122023602082000200028020420046a3602040c010b200541086a200620046b2202410175410120021b220220024102762000410c6a10322103200028020821042000280204210203402002200446450440200328020820022802003602002003200328020841046a360208200241046a21020c010b0b20002902002107200020032902003702002003200737020020002902082107200020032902083702082003200737020820031033200028020821020b200220012802003602002000200028020841046a360208200541206a24000b2501017f200120006b220141027521032001044020022000200110370b200220034102746a0b4f01017f2000410036020c200041106a2003360200200104402001410274103621040b200020043602002000200420024102746a22023602082000200420014102746a36020c2000200236020420000b2b01027f200028020821012000280204210203402001200247044020002001417c6a22013602080c010b0b0b1b00200120006b22010440200220016b22022000200110370b20020b4f01037f20012802042203200128021020012802146a220441087641fcffff07716a21022000027f410020032001280208460d001a2002280200200441ff07714102746a0b360204200020023602000b0b002000410120001b10380b8d0301037f024020002001460d00200120006b20026b410020024101746b4d044020002001200210391a0c010b20002001734103712103027f024020002001490440200020030d021a410021030340200120036a2104200020036a2205410371450440200220036b210241002103034020024104490d04200320056a200320046a280200360200200341046a21032002417c6a21020c000b000b20022003460d04200520042d00003a0000200341016a21030c000b000b024020030d002001417f6a21030340200020026a22044103714504402001417c6a21032000417c6a2104034020024104490d03200220046a200220036a2802003602002002417c6a21020c000b000b2002450d042004417f6a200220036a2d00003a00002002417f6a21020c000b000b2001417f6a210103402002450d03200020026a417f6a200120026a2d00003a00002002417f6a21020c000b000b200320046a2101200320056a0b210303402002450d01200320012d00003a00002002417f6a2102200341016a2103200141016a21010c000b000b0b970101047f230041106b220124002001200036020c2000047f419c0b200041086a22024110762200419c0b2802006a220336020041980b200241980b28020022026a41076a417871220436020002400240200341107420044d0440419c0b200341016a360200200041016a21000c010b2000450d010b200040000d0010000b20022001410c6a4104103941086a0541000b200141106a24000bf80801067f0340200020046a2105200120046a220341037145200220044672450440200520032d00003a0000200441016a21040c010b0b200220046b210602402005410371220845044003402006411049450440200020046a2202200120046a2203290200370200200241086a200341086a290200370200200441106a2104200641706a21060c010b0b027f2006410871450440200120046a2103200020046a0c010b200020046a2202200120046a2201290200370200200141086a2103200241086a0b21042006410471044020042003280200360200200341046a2103200441046a21040b20064102710440200420032f00003b0000200341026a2103200441026a21040b2006410171450d01200420032d00003a000020000f0b024020064120490d002008417f6a220841024b0d00024002400240024002400240200841016b0e020102000b2005200120046a220628020022033a0000200541016a200641016a2f00003b0000200041036a2108200220046b417d6a2106034020064111490d03200420086a2202200120046a220541046a2802002207410874200341187672360200200241046a200541086a2802002203410874200741187672360200200241086a2005410c6a28020022074108742003411876723602002002410c6a200541106a2802002203410874200741187672360200200441106a2104200641706a21060c000b000b2005200120046a220628020022033a0000200541016a200641016a2d00003a0000200041026a2108200220046b417e6a2106034020064112490d03200420086a2202200120046a220541046a2802002207411074200341107672360200200241046a200541086a2802002203411074200741107672360200200241086a2005410c6a28020022074110742003411076723602002002410c6a200541106a2802002203411074200741107672360200200441106a2104200641706a21060c000b000b2005200120046a28020022033a0000200041016a21082004417f7320026a2106034020064113490d03200420086a2202200120046a220541046a2802002207411874200341087672360200200241046a200541086a2802002203411874200741087672360200200241086a2005410c6a28020022074118742003410876723602002002410c6a200541106a2802002203411874200741087672360200200441106a2104200641706a21060c000b000b200120046a41036a2103200020046a41036a21050c020b200120046a41026a2103200020046a41026a21050c010b200120046a41016a2103200020046a41016a21050b20064110710440200520032d00003a00002005200328000136000120052003290005370005200520032f000d3b000d200520032d000f3a000f200541106a2105200341106a21030b2006410871044020052003290000370000200541086a2105200341086a21030b2006410471044020052003280000360000200541046a2105200341046a21030b20064102710440200520032f00003b0000200541026a2105200341026a21030b2006410171450d00200520032d00003a00000b20000bdc0402057f017e23004180016b22002400100910022201103822021003200041206a200041086a20022001103b22034100103c200041206a103d02400240200041206a103e450d002000280224450d0020002802202d000041c001490d010b10000b200041e8006a200041206a103f200028026c220141094f044010000b200028026821020340200104402001417f6a210120023100002005420886842105200241016a21020c010b0b024002402005500d00419d0810402005510440200041206a104110420c020b41a208104020055104402003410210430c020b41b208104020055104402003410310430c020b41c80810402005510440200041e8006a100a210420004100360274200041206a20034101103c200041206a20041044200041206a20034102103c200041206a103d02400240200041206a103e450d002000280224450d0020002802202d000041c001490d010b10000b200041d8006a200041206a103f200028025c220141054f044010000b41002103200028025821020340200104402001417f6a210120022d00002003410874722103200241016a21020c010b0b20002003360274200041206a1041200041c8006a20041016210220002802742103200041206a200041d8006a200210162003102510420c020b41de0810402005520d00200041206a1041200041c8006a200041386a10162102200041e8006a101522012002102810132001200041d8006a20021016101b200128020c200141106a28020047044010000b200128020020012802041008200128020c22020440200120023602100b10420c010b10000b104520004180016a24000b0c00200020012002411c10460bc90202077f017e230041106b220324002001280208220520024b0440200341086a2001105120012003280208200328020c105036020c200320011051410021052001027f410020032802002206450d001a410020032802042208200128020c2207490d001a200820072007417f461b210420060b360210200141146a2004360200200141003602080b200141106a210903402001280214210402402005200249044020040d01410021040b200020092802002004411410461a200341106a24000f0b20032001105141002104027f410020032802002207450d001a410020032802042208200128020c2206490d001a200820066b2104200620076a0b21052001200436021420012005360210200320094100200520041050104f20012003290300220a3702102001200128020c200a422088a76a36020c2001200128020841016a22053602080c000b000b4101017f200028020445044010000b0240200028020022012d0000418101470d00200028020441014d047f100020002802000520010b2c00014100480d0010000b0b980101037f200028020445044041000f0b2000103d200028020022022c0000220141004e044020014100470f0b027f4101200141807f460d001a200141ff0171220341b7014d0440200028020441014d047f100020002802000520020b2d00014100470f0b4100200341bf014b0d001a2000280204200141ff017141ca7e6a22014d047f100020002802000520020b20016a2d00004100470b0bd40101047f200110472204200128020422024b04401000200128020421020b200128020021052000027f02400240200204404100210120052c00002203417f4a0d01027f200341ff0171220141bf014d04404100200341ff017141b801490d011a200141c97e6a0c010b4100200341ff017141f801490d001a200141897e6a0b41016a21010c010b4101210120050d000c010b410021032002200149200120046a20024b720d00410020022004490d011a200120056a2103200220016b20042004417f461b0c010b41000b360204200020033602000b3901027e42a5c688a1c89ca7f94b210103402000300000220250450440200041016a2100200142b383808080207e20028521010c010b0b20010be90101087f230041406a220124002000100a2108200042afb59bdd9e8485b9f800370310200041186a100a2107200141286a1015220320002903101048200328020c200341106a28020047044010000b02402003280200220220032802042206100422044504400c010b2001410036022020014200370318200141186a200410292002200620012802182202200128021c220620026b1005417f4704402001200241016a20062002417f736a103b20071044200421050b2002450d002001200236021c0b200328020c22040440200320043602100b20054504402007200810230b200141406b240020000bfb0201097f230041d0006b22022400200241186a10152103200241c8006a4100360200200241406b4200370300200241386a420037030020024200370330200241306a2000290310102020022802302101200241306a4104721019200320011013200320002903101048200328020c200341106a28020047044010000b200328020421042003280200200241306a10152101200041186a22061028210741011036220041fe013a0000200128020c200141106a28020047044010000b2001280204220841016a220920012802084b047f20012009102b20012802040520080b20012802006a2000410110391a2001200128020441016a3602042001200041016a200720006b6a10132001200241086a20061016101b0240200128020c2001280210460440200128020021000c010b100020012802002100200128020c2001280210460d0010000b2004200020012802041006200128020c22000440200120003602100b200328020c22000440200320003602100b200241d0006a24000b5701027f230041e0006b22022400200241306a100a2103200241086a20004101103c200241086a20031044200241086a1041200241086a200241d0006a200241406b20031016101620011100001042200241e0006a24000bf40201057f230041206b22022400024002402000280204044020002802002d000041c001490d010b200241086a100a1a0c010b200241186a2000103f2000104721030240024002400240200228021822000440200228021c220420034f0d010b41002100200241106a410036020020024200370308410021040c010b200241106a4100360200200242003703082000200420032003417f461b22046a21052004410a4b0d010b200220044101743a0008200241086a41017221030c010b200441106a4170712206103621032002200436020c20022006410172360208200220033602100b03402000200546450440200320002d00003a0000200341016a2103200041016a21000c010b0b200341003a00000b024020012d0000410171450440200141003b01000c010b200128020841003a00002001410036020420012d0000410171450d00200141003602000b20012002290308370200200141086a200241106a280200360200200241086a100d200241206a24000b880101037f41f808410136020041fc08280200210003402000044003404180094180092802002201417f6a2202360200200141014845044041f8084100360200200020024102746a22004184016a280200200041046a28020011020041f808410136020041fc0828020021000c010b0b418009412036020041fc08200028020022003602000c010b0b0b730020004200370210200042ffffffff0f370208200020023602042000200136020002402003410871450d002000104d20024f0d002003410471044010000c010b200042003702000b02402003411071450d002000104d20024d0d0020034104710440100020000f0b200042003702000b20000bff0201037f200028020445044041000f0b2000103d41012102024020002802002c00002201417f4a0d00200141ff0171220341b7014d0440200341807f6a0f0b02400240200141ff0171220141bf014d0440024020002802042201200341c97e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241b7012101034020012003460440200241384f0d030c0405200028020020016a41ca7e6a2d00002002410874722102200141016a21010c010b000b000b200141f7014d0440200341c07e6a0f0b024020002802042201200341897e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241f701210103402001200346044020024138490d0305200028020020016a418a7e6a2d00002002410874722102200141016a21010c010b0b0b200241ff7d490d010b10000b20020b09002000200110211a0bc90201037f200041003a000020004184026a2201417f6a41003a0000200041003a0002200041003a00012001417d6a41003a00002001417e6a41003a0000200041003a00032001417c6a41003a00002000410020006b41037122026a22014100360200200141840220026b417c7122036a2202417c6a4100360200024020034109490d002001410036020820014100360204200241786a4100360200200241746a410036020020034119490d002001410036021820014100360214200141003602102001410036020c200241706a41003602002002416c6a4100360200200241686a4100360200200241646a41003602002003200141047141187222036b2102200120036a2101034020024120490d0120014200370300200141186a4200370300200141106a4200370300200141086a4200370300200141206a2101200241606a21020c000b000b20000b3501017f230041106b220041a08b0436020c41940b200028020c41076a417871220036020041980b2000360200419c0b3f003602000b10002002044020002001200210391a0b0b3801017f41880b420037020041900b410036020041742100034020000440200041940b6a4100360200200041046a21000c010b0b4104100c0b2e01017f200028020445044041000f0b4101210120002802002c0000417f4c047f2000104e200010476a0541010b0b5b00027f027f41002000280204450d001a410020002802002c0000417f4a0d011a20002802002d0000220041bf014d04404100200041b801490d011a200041c97e6a0c010b4100200041f801490d001a200041897e6a0b41016a0b0b5a01027f2000027f0240200128020022054504400c010b200220036a200128020422014b2001200249720d00410020012003490d011a200220056a2104200120026b20032003417f461b0c010b41000b360204200020043602000b2301017f230041206b22022400200241086a2000200141141046104d200241206a24000b2101017f20011047220220012802044b044010000b200020012001104e2002104f0bf80101057f0340024020002802102201200028020c460d00200141786a28020041014904401000200028021021010b200141786a2202200228020041016b220436020020040d002000200236021020004101200028020422032001417c6a28020022026b2201102a220441016a20014138491b220520036a1053200220002802006a220320056a2003200110370240200141374d0440200028020020026a200141406a3a00000c010b200441f7016a220341ff014d0440200028020020026a20033a00002000280200200220046a6a210203402001450d02200220013a0000200141087621012002417f6a21020c000b000b10000b0c010b0b0b0f0020002001102b200020013602040b1b00200028020420016a220120002802084b044020002001102b0b0b2500200041011054200028020020002802046a20013a00002000200028020441016a3602040b0b6f01004180080b687472616e7366657233007472616e7366657232007472616e7366657200696e6974007a65726f5f656d69745f6576656e74007a65726f5f656d69745f6576656e745f6172677332007a65726f5f656d69745f6576656e745f6172677333006765745f737472696e67";

    public static String BINARY = BINARY_0;

    public static final String FUNC_ZERO_EMIT_EVENT = "zero_emit_event";

    public static final String FUNC_ZERO_EMIT_EVENT_ARGS2 = "zero_emit_event_args2";

    public static final String FUNC_ZERO_EMIT_EVENT_ARGS3 = "zero_emit_event_args3";

    public static final String FUNC_GET_STRING = "get_string";

    public static final WasmEvent TRANSFER_EVENT = new WasmEvent("transfer", Arrays.asList(), Arrays.asList(new WasmEventParameter(String.class)));
    ;

    public static final WasmEvent TRANSFER2_EVENT = new WasmEvent("transfer2", Arrays.asList(), Arrays.asList(new WasmEventParameter(String.class) , new WasmEventParameter(String.class)));
    ;

    public static final WasmEvent TRANSFER3_EVENT = new WasmEvent("transfer3", Arrays.asList(), Arrays.asList(new WasmEventParameter(String.class) , new WasmEventParameter(String.class) , new WasmEventParameter(Uint32.class)));
    ;

    protected ContractEmitEvent(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    protected ContractEmitEvent(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        List<WasmContract.WasmEventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (WasmContract.WasmEventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.arg1 = (String) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<TransferEventResponse> transferEventObservable(PlatonFilter filter) {
        return web3j.platonLogObservable(filter).map(new Func1<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse call(Log log) {
                WasmContract.WasmEventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER_EVENT, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.log = log;
                typedResponse.arg1 = (String) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public Observable<TransferEventResponse> transferEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        PlatonFilter filter = new PlatonFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(WasmEventEncoder.encode(TRANSFER_EVENT));
        return transferEventObservable(filter);
    }

    public List<Transfer2EventResponse> getTransfer2Events(TransactionReceipt transactionReceipt) {
        List<WasmContract.WasmEventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER2_EVENT, transactionReceipt);
        ArrayList<Transfer2EventResponse> responses = new ArrayList<Transfer2EventResponse>(valueList.size());
        for (WasmContract.WasmEventValuesWithLog eventValues : valueList) {
            Transfer2EventResponse typedResponse = new Transfer2EventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.arg1 = (String) eventValues.getNonIndexedValues().get(0);
            typedResponse.arg2 = (String) eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<Transfer2EventResponse> transfer2EventObservable(PlatonFilter filter) {
        return web3j.platonLogObservable(filter).map(new Func1<Log, Transfer2EventResponse>() {
            @Override
            public Transfer2EventResponse call(Log log) {
                WasmContract.WasmEventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER2_EVENT, log);
                Transfer2EventResponse typedResponse = new Transfer2EventResponse();
                typedResponse.log = log;
                typedResponse.arg1 = (String) eventValues.getNonIndexedValues().get(0);
                typedResponse.arg2 = (String) eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public Observable<Transfer2EventResponse> transfer2EventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        PlatonFilter filter = new PlatonFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(WasmEventEncoder.encode(TRANSFER2_EVENT));
        return transfer2EventObservable(filter);
    }

    public List<Transfer3EventResponse> getTransfer3Events(TransactionReceipt transactionReceipt) {
        List<WasmContract.WasmEventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER3_EVENT, transactionReceipt);
        ArrayList<Transfer3EventResponse> responses = new ArrayList<Transfer3EventResponse>(valueList.size());
        for (WasmContract.WasmEventValuesWithLog eventValues : valueList) {
            Transfer3EventResponse typedResponse = new Transfer3EventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.arg1 = (String) eventValues.getNonIndexedValues().get(0);
            typedResponse.arg2 = (String) eventValues.getNonIndexedValues().get(1);
            typedResponse.arg3 = (Uint32) eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<Transfer3EventResponse> transfer3EventObservable(PlatonFilter filter) {
        return web3j.platonLogObservable(filter).map(new Func1<Log, Transfer3EventResponse>() {
            @Override
            public Transfer3EventResponse call(Log log) {
                WasmContract.WasmEventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER3_EVENT, log);
                Transfer3EventResponse typedResponse = new Transfer3EventResponse();
                typedResponse.log = log;
                typedResponse.arg1 = (String) eventValues.getNonIndexedValues().get(0);
                typedResponse.arg2 = (String) eventValues.getNonIndexedValues().get(1);
                typedResponse.arg3 = (Uint32) eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public Observable<Transfer3EventResponse> transfer3EventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        PlatonFilter filter = new PlatonFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(WasmEventEncoder.encode(TRANSFER3_EVENT));
        return transfer3EventObservable(filter);
    }

    public static RemoteCall<ContractEmitEvent> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(ContractEmitEvent.class, web3j, credentials, contractGasProvider, encodedConstructor);
    }

    public static RemoteCall<ContractEmitEvent> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(ContractEmitEvent.class, web3j, transactionManager, contractGasProvider, encodedConstructor);
    }

    public static RemoteCall<ContractEmitEvent> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, BigInteger initialVonValue) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(ContractEmitEvent.class, web3j, credentials, contractGasProvider, encodedConstructor, initialVonValue);
    }

    public static RemoteCall<ContractEmitEvent> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, BigInteger initialVonValue) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(ContractEmitEvent.class, web3j, transactionManager, contractGasProvider, encodedConstructor, initialVonValue);
    }

    public RemoteCall<TransactionReceipt> zero_emit_event(String name) {
        final WasmFunction function = new WasmFunction(FUNC_ZERO_EMIT_EVENT, Arrays.asList(name), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> zero_emit_event(String name, BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_ZERO_EMIT_EVENT, Arrays.asList(name), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public RemoteCall<TransactionReceipt> zero_emit_event_args2(String name) {
        final WasmFunction function = new WasmFunction(FUNC_ZERO_EMIT_EVENT_ARGS2, Arrays.asList(name), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> zero_emit_event_args2(String name, BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_ZERO_EMIT_EVENT_ARGS2, Arrays.asList(name), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public RemoteCall<TransactionReceipt> zero_emit_event_args3(String name, Uint32 value) {
        final WasmFunction function = new WasmFunction(FUNC_ZERO_EMIT_EVENT_ARGS3, Arrays.asList(name,value), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> zero_emit_event_args3(String name, Uint32 value, BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_ZERO_EMIT_EVENT_ARGS3, Arrays.asList(name,value), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public RemoteCall<String> get_string() {
        final WasmFunction function = new WasmFunction(FUNC_GET_STRING, Arrays.asList(), String.class);
        return executeRemoteCall(function, String.class);
    }

    public static ContractEmitEvent load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return new ContractEmitEvent(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ContractEmitEvent load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return new ContractEmitEvent(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static class TransferEventResponse {
        public Log log;

        public String arg1;
    }

    public static class Transfer2EventResponse {
        public Log log;

        public String arg1;

        public String arg2;
    }

    public static class Transfer3EventResponse {
        public Log log;

        public String arg1;

        public String arg2;

        public Uint32 arg3;
    }
}
