package network.platon.contracts.wasm;

import com.platon.rlp.datatypes.Int8;
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
public class InitOverloadWithString extends WasmContract {
    private static String BINARY_0 = "0x0061736d01000000014d0d60027f7f0060017f0060017f017f60000060037f7f7f017f60037f7f7f0060027f7f017f60027f7e0060047f7f7f7f0060087f7f7f7f7f7f7f7f006000017f60047f7f7f7f017f60017f017e02a9010703656e760c706c61746f6e5f70616e6963000303656e7617706c61746f6e5f6765745f696e7075745f6c656e677468000a03656e7610706c61746f6e5f6765745f696e707574000103656e760d706c61746f6e5f72657475726e000003656e7617706c61746f6e5f6765745f73746174655f6c656e677468000603656e7610706c61746f6e5f6765745f7374617465000b03656e7610706c61746f6e5f7365745f7374617465000803494803020101000506040006040c0000020103000102070100010001010001070702020002000402050404030202060501000905080301030104020202010806000502010000000000070405017001050505030100020608017f0141908b040b073904066d656d6f72790200115f5f7761736d5f63616c6c5f63746f727300070f5f5f66756e63735f6f6e5f65786974003a06696e766f6b650017090a010041010b040b0f0a3d0a925348100041d80810081a4103103b1030103c0b190020004200370200200041086a41003602002000100920000b2201017f03402001410c470440200020016a4100360200200141046a21010c010b0b0b070041d80810350b0b00200041186a200110360b7c01027f20004200370200200041086a4100360200200010092000200141206a280200200141196a20012d0018220341017122041b2001411c6a280200200341017620041b22012001200228020420022d0000220341017620034101711b22036a103920002002280208200241016a20022d00004101711b200310380bac0201057f027f20002d0000220241017104402000280208210420002802040c010b200041016a210420024101760b2102027f20012d0000220341017104402001280208210520012802040c010b200141016a210520034101760b21030240200520042002200320022003491b100e22042003200249411f7420041b4100480440410121020c010b41ff012102200028020420002d000022044101762203200441017122041b2205200128020420012d00002206410176200641017122061b470d002001280208200141016a20061b21012004450440200041016a210003402003450440410021020c030b20002d000020012d0000470d02200141016a2101200041016a21002003417f6a21030c000b000b417f4100200028020820012005100e1b21020b20024118744118750b1300200245044041000f0b200020012002102f0b7b01017f027f20002d0018220141017104402000411c6a2802002101200041206a2802000c010b20014101762101200041196a0b210002402001450d00200020016a417f6a21010340200020014f0d0120002d00002102200020012d00003a0000200120023a00002001417f6a2101200041016a21000c000b000b0be30101067f027f20002d0018220241017104402000411c6a2802002103200041206a2802000c010b20024101762103200041196a0b2102027f4100027f20012d0000220041017104402001280208210420012802040c010b200141016a210420004101760b2200450d001a200220036a21050240024020032000480d00410120006b210320042d00002107200221010340200520016b22062000480d01200320066a2206450d01200120072006102e2201450d01200120042000100e450d02200141016a21010c000b000b200521010b417f200120026b20012005461b0b4118744118750b3401017f230041106b220324002003200236020c200320013602082003200329030837030020002003411c103e200341106a24000b3901027e42a5c688a1c89ca7f94b210103402000300000220250450440200041016a2100200142b383808080207e20028521010c010b0b20010b7801057f230041d0006b220224002001280200210320012802042101200241306a100821042000200241306a1014200241086a1015200241086a20014101756a2200200241406b2004103322062001410171047f200028020020036a2802000520030b11000020061035101620041035200241d0006a24000b2801017f230041206b22022400200241086a200041011046200241086a20011028200241206a24000bde02010c7f230041406a2201240020001008210a20004295cf95d0e0dbf488997f370310200041186a10082108200141286a101a220420002903101024200428020c200441106a28020047044010000b024002402004280200220b2004280204220c10042203450440410021030c010b20014100360220200142003703182003417f4c0d012003103221050340200220056a41003a00002003200241016a2202470d000b200220056a21072005200128021c200128021822066b22096b2102200941014e0440200220062009102b1a200128021821060b2001200320056a3602202001200736021c200120023602180240200b200c20060440200128021c2107200128021821020b2002200720026b1005417f460440410021030c010b20012001280218220241016a200128021c2002417f736a1011200810280b200141186a10210b2004101e20034504402008200a10360b200141406b240020000f0b000bb103010c7f230041e0006b22012400200141286a101a2104200141d8006a4100360200200141d0006a4200370300200141c8006a420037030020014200370340200141406b2000290310102520012802402103200141406b410472101c20042003101d200420002903101024200428020c200441106a28020047044010000b200428020421092004280200200141406b101a2102200041186a22071029210b41011032220341fe013a0000200120033602182001200341016a22053602202001200536021c200228020c200241106a2802004704401000200128021c2105200128021821030b2003210620022802042208200520036b22056a220c20022802084b04402002200c102220022802042108200128021821060b200228020020086a20032005102b1a2002200228020420056a3602042002200128021c200b20066b6a101d2002200141086a200710332203102a200310350240200228020c2002280210460440200228020021030c010b100020022802002103200228020c2002280210460d0010000b2009200320022802041006200141186a10212002101e2004101e2007103520001035200141e0006a24000bbf0602067f017e230041a0016b22002400100710012201103122021002200041f8006a200041186a200220011011220141001046200041f8006a104202400240200041f8006a1047450d00200028027c450d0020002802782d000041c001490d010b10000b200041c8006a200041f8006a1018200028024c220241094f044010000b200028024821030340200204402002417f6a210220033100002006420886842106200341016a21030c010b0b024002402006500d00418008101220065104402000410036027c20004101360278200020002903783703082001200041086a10130c020b41850810122006510440200041f8006a1015200041c8006a20004190016a1033220210192002103510160c020b41900810122006510440200041f8006a101520004194016a280200210420002d0090012102200041306a101a2101200041e0006a4100360200200041d8006a4200370300200041d0006a420037030020004200370348200041c8006a2004200241017620024101711b41ff0171ad2206101b20002802482102200041c8006a410472101c20012002101d20012006104e200128020c200141106a28020047044010000b2001280200200128020410032001101e10160c020b419e0810122006510440200041e8006a100821022001200041e8006a1014200041f8006a1015200041c8006a200041f8006a200041306a200210332203100c200041c8006a1019200041c8006a1035200310351016200210350c020b41ac0810122006510440200041c8006a10082102200041d4006a1008210320004101360230200020013602782000200041306a36027c200041f8006a2002101f200041f8006a2003101f200041f8006a10152000200041306a200210332204200041e8006a200310332205100d3a0077200041f7006a10202005103520041035101620031035200210350c020b41bb08101220065104402000410036027c20004102360278200020002903783703102001200041106a10130c020b41ca0810122006520d00200041306a100821022001200041306a1014200041f8006a10152000200041f8006a200041c8006a20021033220310103a0068200041e8006a1020200310351016200210350c010b10000b103a200041a0016a24000bd60101047f200110412204200128020422024b04401000200128020421020b20012802002105027f027f41002002450d001a410020052c00002203417f4a0d011a200341ff0171220141bf014d04404100200341ff017141b801490d011a200141c97e6a0c010b4100200341ff017141f801490d001a200141897e6a0b41016a0b21012000027f02402005450440410021030c010b410021032002200149200120046a20024b720d00410020022004490d011a200120056a2103200220016b20042004417f461b0c010b41000b360204200020033602000b5901027f230041306b22022400200241186a101a220120001029101d2001200241086a200010332200102a20001035200128020c200141106a28020047044010000b2001280200200128020410032001101e200241306a24000b29002000410036020820004200370200200041001022200041146a41003602002000420037020c20000b7502027f017e4101210320014280015a0440034020012004845045044020044238862001420888842101200241016a2102200442088821040c010b0b200241384f047f2002102620026a0520020b41016a21030b200041186a2802000440200041046a102721000b2000200028020020036a3602000bc40201067f200028020422012000280210220341087641fcffff07716a2102027f200120002802082205460440200041146a210441000c010b2001200028021420036a220441087641fcffff07716a280200200441ff07714102746a2106200041146a21042002280200200341ff07714102746a0b21030340024020032006460440200441003602000340200520016b41027522024103490d0220012802001a2000200028020441046a2201360204200028020821050c000b000b200341046a220320022802006b418020470d0120022802042103200241046a21020c010b0b2002417f6a220241014d04402000418004418008200241016b1b3602100b03402001200547044020012802001a200141046a21010c010b0b200028020821012000280204210203402001200247044020002001417c6a22013602080c010b0b20002802001a0b1300200028020820014904402000200110220b0b1c01017f200028020c22010440200041106a20013602000b200010230b4301017f230041206b22022400200241086a200028020020002802042802001046200241086a2001102820002802042200200028020041016a360200200241206a24000ba90102037f017e230041406a22012400200141086a101a2102200141386a4100360200200141306a4200370300200141286a420037030020014200370320200141206a200030000022044201862004423f8785102520012802202103200141206a410472101c20022003101d2002200030000022044201862004423f87851024200228020c200241106a28020047044010000b2002280200200228020410032002101e200141406b24000b1501017f200028020022010440200020013602040b0b3401017f2000280208200149044020011031220220002802002000280204102b1a2000102320002001360208200020023602000b0b080020002802001a0b080020002001104e0b080020002001101b0b1e01017f03402000044020004108762100200141016a21010c010b0b20010b2e002000280204200028021420002802106a417f6a220041087641fcffff07716a280200200041ff07714102746a0b8c0301057f230041206b220224000240024002402000280204044020002802002d000041c001490d010b200241086a10081a0c010b200241186a200010182000104121030240024002400240200228021822000440200228021c220420034f0d010b41002100200241106a410036020020024200370308410021030c010b200241106a410036020020024200370308200420032003417f461b220341704f0d04200020036a21052003410a4b0d010b200220034101743a0008200241086a41017221040c010b200341106a4170712206103221042002200336020c20022006410172360208200220043602100b034020002005470440200420002d00003a0000200441016a2104200041016a21000c010b0b200441003a00000b024020012d0000410171450440200141003b01000c010b200128020841003a00002001410036020420012d0000410171450d0020012802081a200141003602000b20012002290308370200200141086a200241106a280200360200200241086a1009200241086a1035200241206a24000f0b000bbc0101047f230041306b22012400200141286a4100360200200141206a4200370300200141186a42003703002001420037031041012102024002400240200120001033220328020420032d00002200410176200041017122041b220041014d0440200041016b0d032003280208200341016a20041b2c0000417f4c0d010c030b200041374b0d010b200041016a21020c010b2000102620006a41016a21020b2001200236021020031035200141106a410472101c200141306a240020020b5201037f230041106b2202240020022001280208200141016a20012d0000220341017122041b36020820022001280204200341017620041b36020c2002200229030837030020002002104d200241106a24000bf80801067f0340200020046a2105200120046a220341037145200220044672450440200520032d00003a0000200441016a21040c010b0b200220046b210602402005410371220845044003402006411049450440200020046a2202200120046a2203290200370200200241086a200341086a290200370200200441106a2104200641706a21060c010b0b027f2006410871450440200120046a2103200020046a0c010b200020046a2202200120046a2201290200370200200141086a2103200241086a0b21042006410471044020042003280200360200200341046a2103200441046a21040b20064102710440200420032f00003b0000200341026a2103200441026a21040b2006410171450d01200420032d00003a000020000f0b024020064120490d002008417f6a220841024b0d00024002400240024002400240200841016b0e020102000b2005200120046a220628020022033a0000200541016a200641016a2f00003b0000200041036a2108200220046b417d6a2106034020064111490d03200420086a2202200120046a220541046a2802002207410874200341187672360200200241046a200541086a2802002203410874200741187672360200200241086a2005410c6a28020022074108742003411876723602002002410c6a200541106a2802002203410874200741187672360200200441106a2104200641706a21060c000b000b2005200120046a220628020022033a0000200541016a200641016a2d00003a0000200041026a2108200220046b417e6a2106034020064112490d03200420086a2202200120046a220541046a2802002207411074200341107672360200200241046a200541086a2802002203411074200741107672360200200241086a2005410c6a28020022074110742003411076723602002002410c6a200541106a2802002203411074200741107672360200200441106a2104200641706a21060c000b000b2005200120046a28020022033a0000200041016a21082004417f7320026a2106034020064113490d03200420086a2202200120046a220541046a2802002207411874200341087672360200200241046a200541086a2802002203411874200741087672360200200241086a2005410c6a28020022074118742003410876723602002002410c6a200541106a2802002203411874200741087672360200200441106a2104200641706a21060c000b000b200120046a41036a2103200020046a41036a21050c020b200120046a41026a2103200020046a41026a21050c010b200120046a41016a2103200020046a41016a21050b20064110710440200520032d00003a00002005200328000136000120052003290005370005200520032f000d3b000d200520032d000f3a000f200541106a2105200341106a21030b2006410871044020052003290000370000200541086a2105200341086a21030b2006410471044020052003280000360000200541046a2105200341046a21030b20064102710440200520032f00003b0000200541026a2105200341026a21030b2006410171450d00200520032d00003a00000b20000bc90201037f200041003a000020004184026a2201417f6a41003a0000200041003a0002200041003a00012001417d6a41003a00002001417e6a41003a0000200041003a00032001417c6a41003a00002000410020006b41037122026a22014100360200200141840220026b417c7122036a2202417c6a4100360200024020034109490d002001410036020820014100360204200241786a4100360200200241746a410036020020034119490d002001410036021820014100360214200141003602102001410036020c200241706a41003602002002416c6a4100360200200241686a4100360200200241646a41003602002003200141047141187222036b2102200120036a2101034020024120490d0120014200370300200141186a4200370300200141106a4200370300200141086a4200370300200141206a2101200241606a21020c000b000b20000b8d0301037f024020002001460d00200120006b20026b410020024101746b4d0440200020012002102b1a0c010b20002001734103712103027f024020002001490440200020030d021a410021030340200120036a2104200020036a2205410371450440200220036b210241002103034020024104490d04200320056a200320046a280200360200200341046a21032002417c6a21020c000b000b20022003460d04200520042d00003a0000200341016a21030c000b000b024020030d002001417f6a21030340200020026a22044103714504402001417c6a21032000417c6a2104034020024104490d03200220046a200220036a2802003602002002417c6a21020c000b000b2002450d042004417f6a200220036a2d00003a00002002417f6a21020c000b000b2001417f6a210103402002450d03200020026a417f6a200120026a2d00003a00002002417f6a21020c000b000b200320046a2101200320056a0b210303402002450d01200320012d00003a00002002417f6a2102200341016a2103200141016a21010c000b000b0bcf0101027f200141ff017121030240024003402002452000410371457245044020002d00002003460d022002417f6a2102200041016a21000c010b0b20020d00410021020c010b20002d0000200141ff0171460d00200341818284086c2103034020024104490d0120002802002003732204417f73200441fffdfb776a71418081828478710d012002417c6a2102200041046a21000c000b000b200141ff01712101034002402002450440410021000c010b20002d00002001460d002002417f6a2102200041016a21000c010b0b20000b3e01027f0340200245044041000f0b20002d0000220320012d00002204460440200141016a2101200041016a21002002417f6a21020c010b0b200320046b0b3501017f230041106b220041908b0436020c41800b200028020c41076a417871220036020041840b200036020041880b3f003602000b970101047f230041106b220124002001200036020c2000047f41880b200041086a2202411076220041880b2802006a220336020041840b200241840b28020022026a41076a417871220436020002400240200341107420044d044041880b200341016a360200200041016a21000c010b2000450d010b200040000d0010000b20022001410c6a4104102b41086a0541000b200141106a24000b0b002000410120001b10310ba10101037f20004200370200200041086a2202410036020020012d0000410171450440200020012902003702002002200141086a28020036020020000f0b20012802082103024020012802042201410a4d0440200020014101743a0000200041016a21020c010b200141106a4170712204103221022000200136020420002004410172360200200020023602080b2002200320011034200120026a41003a000020000b100020020440200020012002102b1a0b0b130020002d0000410171044020002802081a0b0bd40101047f20002001470440200128020420012d00002202410176200241017122031b2102200141016a21042001280208410a2101200420031b210320002d00002205410171220404402000280200417e71417f6a21010b200220014d0440027f2004044020002802080c010b200041016a0b210120020440200120032002102d0b200120026a41003a000020002d00004101710440200020023602040f0b200020024101743a00000f0b20002001200220016b027f2004044020002802040c010b20054101760b2200410020002002200310370b0bc30101027f027f20002d0000410171044020002802080c010b200041016a0b2109416f2108200141e6ffffff074d0440410b20014101742208200120026a220220022008491b220241106a4170712002410b491b21080b2008103221022004044020022009200410340b20060440200220046a2007200610340b200320056b220320046b22070440200220046a20066a200420096a20056a200710340b200020023602082000200320066a220136020420002008410172360200200120026a41003a00000bb00101037f0240027f20002d0000220341017122050440200028020421032000280200417e71417f6a0c010b20034101762103410a0b220420036b20024f04402002450d01027f2005044020002802080c010b200041016a0b220420036a200120021034200220036a2101024020002d00004101710440200020013602040c010b200020014101743a00000b200120046a41003a00000f0b20002004200220036a20046b2003200341002002200110370b0b5a01017f02402003410a4d0440200020024101743a0000200041016a21030c010b200341106a4170712204103221032000200236020420002004410172360200200020033602080b2003200120021034200220036a41003a00000b880101037f41e408410136020041e8082802002100034020000440034041ec0841ec082802002201417f6a2202360200200141014845044041e4084100360200200020024102746a22004184016a280200200041046a28020011010041e408410136020041e80828020021000c010b0b41ec08412036020041e808200028020022003602000c010b0b0b940101027f41e408410136020041e808280200220145044041e80841f00836020041f00821010b024041ec082802002202412046044041840210312201450d012001102c220141e80828020036020041e808200136020041ec084100360200410021020b41ec08200241016a360200200120024102746a22014184016a4100360200200141046a20003602000b41e40841003602000b3801017f41f40a420037020041fc0a410036020041742100034020000440200041800b6a4100360200200041046a21000c010b0b4104103b0b070041f40a10350b750020004200370210200042ffffffff0f3702082000200129020037020002402002410871450d002000103f20012802044f0d002002410471044010000c010b200042003702000b02402002411071450d002000103f20012802044d0d0020024104710440100020000f0b200042003702000b20000b2e01017f200028020445044041000f0b4101210120002802002c0000417f4c047f20001040200010416a0541010b0b5b00027f027f41002000280204450d001a410020002802002c0000417f4a0d011a20002802002d0000220041bf014d04404100200041b801490d011a200041c97e6a0c010b4100200041f801490d001a200041897e6a0b41016a0b0bff0201037f200028020445044041000f0b2000104241012102024020002802002c00002201417f4a0d00200141ff0171220341b7014d0440200341807f6a0f0b02400240200141ff0171220141bf014d0440024020002802042201200341c97e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241b7012101034020012003460440200241384f0d030c0405200028020020016a41ca7e6a2d00002002410874722102200141016a21010c010b000b000b200141f7014d0440200341c07e6a0f0b024020002802042201200341897e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241f701210103402001200346044020024138490d0305200028020020016a418a7e6a2d00002002410874722102200141016a21010c010b0b0b200241ff7d490d010b10000b20020b4101017f200028020445044010000b0240200028020022012d0000418101470d00200028020441014d047f100020002802000520010b2c00014100480d0010000b0b5a01027f2000027f0240200128020022054504400c010b200220036a200128020422014b2001200249720d00410020012003490d011a200220056a2104200120026b20032003417f461b0c010b41000b360204200020043602000b3c01017f230041306b22022400200220013602142002200036021020022002290310370308200241186a200241086a4114103e103f200241306a24000b2101017f20011041220220012802044b044010000b2000200120011040200210430bd60202077f017e230041206b220324002001280208220420024b0440200341186a2001104520012003280218200328021c104436020c200341106a20011045410021042001027f410020032802102206450d001a410020032802142208200128020c2207490d001a200820072007417f461b210520060b360210200141146a2005360200200141003602080b200141106a210903400240200420024f0d002001280214450d00200341106a2001104541002104027f410020032802102207450d001a410020032802142208200128020c2206490d001a200820066b2104200620076a0b21052001200436021420012005360210200341106a20094100200520041044104320012003290310220a3702102001200128020c200a422088a76a36020c2001200128020841016a22043602080c010b0b20032009290200220a3703082003200a370300200020034114103e1a200341206a24000b980101037f200028020445044041000f0b20001042200028020022022c0000220141004e044020014100470f0b027f4101200141807f460d001a200141ff0171220341b7014d0440200028020441014d047f100020002802000520020b2d00014100470f0b4100200341bf014b0d001a2000280204200141ff017141ca7e6a22014d047f100020002802000520020b20016a2d00004100470b0bf80101057f0340024020002802102201200028020c460d00200141786a28020041014904401000200028021021010b200141786a2202200228020041016b220436020020040d002000200236021020004101200028020422032001417c6a28020022026b22011026220441016a20014138491b220520036a1049200220002802006a220320056a20032001102d0240200141374d0440200028020020026a200141406a3a00000c010b200441f7016a220341ff014d0440200028020020026a20033a00002000280200200220046a6a210203402001450d02200220013a0000200141087621012002417f6a21020c000b000b10000b0c010b0b0b0f0020002001104a200020013602040b2f01017f200028020820014904402001103120002802002000280204102b210220002001360208200020023602000b0b1b00200028020420016a220120002802084b044020002001104a0b0b250020004101104b200028020020002802046a20013a00002000200028020441016a3602040be70101037f2001280200210441012102024002400240024020012802042201410146044020042c000022014100480d012000200141ff0171104c0c040b200141374b0d01200121020b200020024180017341ff0171104c0c010b20011026220241b7016a22034180024e044010000b2000200341ff0171104c2000200028020420026a1049200028020420002802006a417f6a210320012102037f2002047f200320023a0000200241087621022003417f6a21030c010520010b0b21020b20002002104b200028020020002802046a20042002102b1a2000200028020420026a3602040b200010480bb80202037f037e024020015004402000418001104c0c010b20014280015a044020012105034020052006845045044020064238862005420888842105200241016a2102200642088821060c010b0b0240200241384f04402002210303402003044020034108762103200441016a21040c010b0b200441c9004f044010000b2000200441b77f6a41ff0171104c2000200028020420046a1049200028020420002802006a417f6a21042002210303402003450d02200420033a0000200341087621032004417f6a21040c000b000b200020024180017341ff0171104c0b2000200028020420026a1049200028020420002802006a417f6a210203402001200784500d02200220013c0000200742388620014208888421012002417f6a2102200742088821070c000b000b20002001a741ff0171104c0b200010480b0b5c01004180080b55696e6974006765745f737472696e6700737472696e675f6c656e67746800737472696e675f73706c69636500737472696e675f636f6d7061726500737472696e675f7265766572736500737472696e675f66696e64";

    public static String BINARY = BINARY_0;

    public static final String FUNC_GET_STRING = "get_string";

    public static final String FUNC_STRING_LENGTH = "string_length";

    public static final String FUNC_STRING_SPLICE = "string_splice";

    public static final String FUNC_STRING_COMPARE = "string_compare";

    public static final String FUNC_STRING_REVERSE = "string_reverse";

    public static final String FUNC_STRING_FIND = "string_find";

    protected InitOverloadWithString(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    protected InitOverloadWithString(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<String> get_string() {
        final WasmFunction function = new WasmFunction(FUNC_GET_STRING, Arrays.asList(), String.class);
        return executeRemoteCall(function, String.class);
    }

    public static RemoteCall<InitOverloadWithString> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, String initStr) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList(initStr));
        return deployRemoteCall(InitOverloadWithString.class, web3j, credentials, contractGasProvider, encodedConstructor);
    }

    public static RemoteCall<InitOverloadWithString> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, String initStr) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList(initStr));
        return deployRemoteCall(InitOverloadWithString.class, web3j, transactionManager, contractGasProvider, encodedConstructor);
    }

    public static RemoteCall<InitOverloadWithString> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, BigInteger initialVonValue, String initStr) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList(initStr));
        return deployRemoteCall(InitOverloadWithString.class, web3j, credentials, contractGasProvider, encodedConstructor, initialVonValue);
    }

    public static RemoteCall<InitOverloadWithString> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, BigInteger initialVonValue, String initStr) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList(initStr));
        return deployRemoteCall(InitOverloadWithString.class, web3j, transactionManager, contractGasProvider, encodedConstructor, initialVonValue);
    }

    public RemoteCall<Uint8> string_length() {
        final WasmFunction function = new WasmFunction(FUNC_STRING_LENGTH, Arrays.asList(), Uint8.class);
        return executeRemoteCall(function, Uint8.class);
    }

    public RemoteCall<String> string_splice(String spliceStr) {
        final WasmFunction function = new WasmFunction(FUNC_STRING_SPLICE, Arrays.asList(spliceStr), String.class);
        return executeRemoteCall(function, String.class);
    }

    public RemoteCall<Int8> string_compare(String strone, String strtwo) {
        final WasmFunction function = new WasmFunction(FUNC_STRING_COMPARE, Arrays.asList(strone,strtwo), Int8.class);
        return executeRemoteCall(function, Int8.class);
    }

    public RemoteCall<TransactionReceipt> string_reverse(String reverseStr) {
        final WasmFunction function = new WasmFunction(FUNC_STRING_REVERSE, Arrays.asList(reverseStr), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> string_reverse(String reverseStr, BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_STRING_REVERSE, Arrays.asList(reverseStr), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public RemoteCall<Int8> string_find(String findStr) {
        final WasmFunction function = new WasmFunction(FUNC_STRING_FIND, Arrays.asList(findStr), Int8.class);
        return executeRemoteCall(function, Int8.class);
    }

    public static InitOverloadWithString load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return new InitOverloadWithString(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static InitOverloadWithString load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return new InitOverloadWithString(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
