package trader.service.md;

import java.util.Collection;
import java.util.List;

import trader.common.beans.Lifecycle;
import trader.common.exchangeable.Exchangeable;

/**
 * 行情服务.
 * <BR>从多个行情数据源整合并生成行情数据并回调, 自动合并相同tick
 */
public interface MarketDataService extends Lifecycle {

    /**
     * 当前的行情数据源状态
     */
    public Collection<MarketDataProducer> getProducers();

    public MarketDataProducer getProducer(String producerId);

    /**
     * 当前已订阅品种
     */
    public Collection<Exchangeable> getSubscriptions();

    /**
     * 最后行情数据
     */
    public MarketData getLastData(Exchangeable e);

    /**
     * 增加主动订阅品种
     */
    public void addSubscriptions(List<Exchangeable> subscriptions);

    /**
     * 行情回调接口, 如果exchangables==null, 那么所有的行情都会被调用
     */
    public void addListener(MarketDataListener listener, Exchangeable... exchangeables);

}
