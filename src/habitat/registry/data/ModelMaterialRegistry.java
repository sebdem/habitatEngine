package habitat.registry.data;

import habitat.data.models.ModelMaterial;

import java.util.HashMap;
import java.util.Map;

public class ModelMaterialRegistry {
    public static ModelMaterialRegistry registry = new ModelMaterialRegistry();

    private Map<Integer, ModelMaterial> register;


    private ModelMaterialRegistry() {
        register = new HashMap<>(128);
    }

    public ModelMaterialRegistry registerMaterial(Integer id, ModelMaterial modelMaterial) {
        if (register.containsKey(id)){
            // TODO implement logging/exception
        } else {
            register.put(id, modelMaterial);
        }
        return this;
    }
}
