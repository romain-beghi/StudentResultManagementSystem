import * as React from "react";

export const Select = ({ name, value, options, onChange }) => {
    return (
        <select name={name} value={value} onChange={onChange}>
            {options.map((option) => (
                <option value={option.value}>{option.label}</option>
            ))}
        </select>
    );
};
