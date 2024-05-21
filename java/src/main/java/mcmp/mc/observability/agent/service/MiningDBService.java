package mcmp.mc.observability.agent.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mcmp.mc.observability.agent.enums.ResultCode;
import mcmp.mc.observability.agent.exception.ResultCodeException;
import mcmp.mc.observability.agent.mapper.MiningDBMapper;
import mcmp.mc.observability.agent.model.dto.MiningDBCreateDTO;
import mcmp.mc.observability.agent.model.dto.ResBody;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MiningDBService {

    private final MiningDBMapper miningDBMapper;

    public ResBody create(MiningDBCreateDTO info) {
        ResBody<Void> resBody = new ResBody<>();
        try {
            int result = miningDBMapper.insertMiningDB(info);
            if (result <= 0) {
                throw new ResultCodeException(ResultCode.INVALID_ERROR, "Host Storage insert error QueryResult={}", result);
            }
        } catch (ResultCodeException e) {
            resBody.setCode(e.getResultCode());
        } catch (Exception e) {
            resBody.setCode(ResultCode.INVALID_REQUEST);
        }
        return resBody;
    }
}
