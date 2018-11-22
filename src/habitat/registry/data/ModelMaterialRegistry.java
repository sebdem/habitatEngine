package habitat.registry.data;

import habitat.data.models.ModelMaterial;

import java.util.HashMap;
import java.util.Map;

public class ModelMaterialRegistry {
    public static ModelMaterialRegistry registry = new ModelMaterialRegistry();

    private Map<String, ModelMaterial> register;


    private ModelMaterialRegistry() {
        register = new HashMap<>(128);
        registerMaterial("habitat:placeholder", new ModelMaterial());
    }

    public ModelMaterialRegistry registerMaterial(String id, ModelMaterial modelMaterial) {
        if (register.containsKey(id)){
            // TODO implement logging/exception
        } else {
            register.put(id, modelMaterial);
        }
        return this;
    }
}
